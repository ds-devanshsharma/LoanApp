package com.coding.LoanApp.model.request;

import com.coding.LoanApp.enums.LoanType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoanApplyRequestDTO {
    private String customerId ;
    private double loanAmount ;
    private int tenure ; // in months
    private LoanType loanType ;
}
