package com.coding.LoanApp.utils;

public class LoanUtils {
    public static double getEMIAmount(double loanAmount , double rate , int tenure){
        return ( loanAmount * rate ) / (1 - Math.pow(1+rate , -tenure));
    }

    public static String getLoanStatus(int remainingEMIs) {
        return remainingEMIs > 0 ? "ACTIVE" : "CLOSED";
    }

    public static double roundTillTwoDigit(double amount) {
        return Math.round(amount * 100.0 )/100.0 ;
    }
}
