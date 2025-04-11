package com.coding.LoanApp.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class LoanStatusResponseDTO {
    private String loanId ;
    private double totalAmountPaidTillNow ;
    private double totalDue ;
    private double totalRemainingDueAmount;
    private double EMIAmount ;
    private int remainingEMIs;
    private String status ;
}
