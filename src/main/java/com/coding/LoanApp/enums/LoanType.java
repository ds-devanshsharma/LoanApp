package com.coding.LoanApp.enums;

public enum LoanType {
    PERSONAL(12.5),
    HOME(8.0);

    private final double interestRate ;
    LoanType(double rate) {this.interestRate = rate;}
    public double getInterestRate(){
        return interestRate ;
    }
    public double getMonthlyInterestRate(){
        return interestRate /100 /12 ;
    }
}
