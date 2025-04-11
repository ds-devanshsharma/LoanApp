package com.coding.LoanApp.service;

import com.coding.LoanApp.exceptions.LoanException;
import com.coding.LoanApp.model.request.LoanApplyRequestDTO;
import com.coding.LoanApp.model.response.LoanInfoResponseDTO;
import com.coding.LoanApp.model.response.LoanStatusResponseDTO;

import java.util.List;

public interface LoanService {
    String apply(LoanApplyRequestDTO requestDTO) throws LoanException;
    List<LoanInfoResponseDTO> getLoanInfo(String customerId);
    LoanInfoResponseDTO getLoanInfoByLoanId(String loanId ) throws LoanException;
    String loanRepayment(String loanId) throws LoanException;
    LoanStatusResponseDTO getLoanStatus(String loanId ) throws LoanException;
}
