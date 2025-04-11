package com.coding.LoanApp.service.impl;

import com.coding.LoanApp.entities.Customer;
import com.coding.LoanApp.entities.Loan;
import com.coding.LoanApp.entities.Payment;
import com.coding.LoanApp.exceptions.LoanException;
import com.coding.LoanApp.model.request.LoanApplyRequestDTO;
import com.coding.LoanApp.model.response.LoanInfoResponseDTO;
import com.coding.LoanApp.model.response.LoanStatusResponseDTO;
import com.coding.LoanApp.projection.PaymentProjection;
import com.coding.LoanApp.repository.CustomerRepository;
import com.coding.LoanApp.repository.LoanRepository;
import com.coding.LoanApp.repository.PaymentRepository;
import com.coding.LoanApp.service.LoanService;
import com.coding.LoanApp.utils.LoanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private CustomerRepository customerRepository ;

    @Autowired
    private LoanRepository loanRepository ;
    @Autowired
    private PaymentRepository paymentRepository ;

    @Override
    public String apply(LoanApplyRequestDTO requestDTO) throws LoanException {
        // check customer exist into the system
        Customer customer = customerRepository.findById(requestDTO.getCustomerId())
                .orElseThrow( () -> new LoanException("Customer Doesn't Exist , redirect to signup page"));

        // prepare loan
        Loan loan = new Loan();
        loan.setCustomer(customer);
        loan.setLoanAmount(requestDTO.getLoanAmount());
        loan.setLoanType(requestDTO.getLoanType());
        loan.setTenure(requestDTO.getTenure());
        // prepare  amount
        double EMIAmount = LoanUtils.getEMIAmount(
                requestDTO.getLoanAmount(),
                requestDTO.getLoanType().getMonthlyInterestRate(),
                requestDTO.getTenure()
        );
        loan.setInstallmentAmount(LoanUtils.roundTillTwoDigit(EMIAmount));
        loan = loanRepository.save(loan);

        return loan.getId();
    }

    @Override
    public List<LoanInfoResponseDTO> getLoanInfo(String customerId) {

        return List.of();
    }

    @Override
    public LoanInfoResponseDTO getLoanInfoByLoanId(String loanId) throws LoanException {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(
                        ()-> new LoanException("Loan info doesn't exists !")
                );
        // preparing response we can from projection as well directly in DTO

        return LoanInfoResponseDTO.builder()
                .loanAmount(loan.getLoanAmount())
                .loanType(loan.getLoanType())
                .tenure(loan.getTenure())
                .installmentAmount(loan.getInstallmentAmount())
                .createdAt(loan.getCreatedAt())
                .build();
    }

    /** Method to handle re-payment of loan
     * Consider it like a webhook whenever payment is done
     * we'll get hit on behalf on loanID
     * @param loanId
     * @return
     */
    @Override
    public String loanRepayment(String loanId) throws LoanException {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(
                        () -> new LoanException("Loan doesn't Exists!")
                );
        //
        // add Payment for respective loan
        Payment payment = new Payment();
        payment.setLoan(loan);
        payment.setAmount(loan.getInstallmentAmount());
        payment = paymentRepository.save(payment);

        return payment.getId();
    }

    @Override
    public LoanStatusResponseDTO getLoanStatus(String loanId) throws LoanException {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(
                        ()-> new LoanException("Loan Doesn't Exists!")
                );
        List<PaymentProjection> payments = paymentRepository.findByLoanId(loanId);
        // prepare response
        return prepareLoanStatusResposne(loan, payments);
    }

    private LoanStatusResponseDTO prepareLoanStatusResposne(Loan loan, List<PaymentProjection> payments) {
        double totalPaidTillNow = payments.stream()
                .mapToDouble(PaymentProjection::getAmount)
                .sum();
        double totalDueAmount = loan.getInstallmentAmount() * loan.getTenure() ;
        double remainingAmount = totalDueAmount - totalPaidTillNow ;
        int monthPaid = (int) (totalPaidTillNow / loan.getInstallmentAmount()) ;
        int remainingEMIs = loan.getTenure() - monthPaid ;

        return LoanStatusResponseDTO.builder()
                .loanId(loan.getId())
                .totalDue(LoanUtils.roundTillTwoDigit(totalDueAmount))
                .totalAmountPaidTillNow(LoanUtils.roundTillTwoDigit(totalPaidTillNow))
                .totalRemainingDueAmount(LoanUtils.roundTillTwoDigit(remainingAmount))
                .EMIAmount(loan.getInstallmentAmount())
                .remainingEMIs(remainingEMIs)
                .status(LoanUtils.getLoanStatus(remainingEMIs))
                .build();
    }
}
