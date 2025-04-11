package com.coding.LoanApp.model.response;

import com.coding.LoanApp.enums.LoanType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoanApplyResponseDTO {
    private String loanId ;
    private double loanAmount ;
    private LoanType loanType ;
}
