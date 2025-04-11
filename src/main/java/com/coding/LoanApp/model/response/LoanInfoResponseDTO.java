package com.coding.LoanApp.model.response;

import com.coding.LoanApp.enums.LoanType;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Builder
public class LoanInfoResponseDTO {

    private double loanAmount ;
    private double installmentAmount ;
    private LoanType loanType ;
    private int tenure ;
    private LocalDateTime createdAt ;

}
