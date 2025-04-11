package com.coding.LoanApp.controller;

import com.coding.LoanApp.exceptions.LoanException;
import com.coding.LoanApp.model.request.LoanApplyRequestDTO;
import com.coding.LoanApp.model.response.ApiResponseDTO;
import com.coding.LoanApp.model.response.LoanInfoResponseDTO;
import com.coding.LoanApp.model.response.LoanStatusResponseDTO;
import com.coding.LoanApp.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private LoanService loanService ;
    /**
     * Consider user already created into system
     * then he is applying for loan
     * @return
     */
    // apply loan
    @PostMapping("/apply")
    ResponseEntity<ApiResponseDTO<String>> applyController(@RequestBody LoanApplyRequestDTO requestDTO) throws LoanException {
        String loanId = loanService.apply(requestDTO);
        return ResponseEntity.ok(ApiResponseDTO.success(loanId, "Loan initiated Successfully !"));
    }

    // loan details
    @GetMapping("")
    ResponseEntity<ApiResponseDTO<LoanInfoResponseDTO>> getLoanInfoController(@RequestParam String loanId) throws LoanException {
        LoanInfoResponseDTO loanInfo = loanService.getLoanInfoByLoanId(loanId);
        return ResponseEntity.ok(ApiResponseDTO.success(loanInfo, "LoanInfo fetched Successfully!"));
    }

    // loan payment
    @PostMapping("/repay")
    ResponseEntity<ApiResponseDTO<String>> repayController(@RequestParam String loanId) throws LoanException {
        String transactionId = loanService.loanRepayment(loanId);
        return ResponseEntity.ok(ApiResponseDTO.success(transactionId , "Payment Success"));
    }

    // loan status
    @GetMapping("/status")
    ResponseEntity<ApiResponseDTO<LoanStatusResponseDTO>> statusController(@RequestParam String loanId) throws LoanException {
        LoanStatusResponseDTO loanStatus = loanService.getLoanStatus(loanId);
        return ResponseEntity.ok(ApiResponseDTO.success(loanStatus, "Loan Status Fetched !"));
    }
}
