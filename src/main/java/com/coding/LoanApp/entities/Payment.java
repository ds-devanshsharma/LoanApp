package com.coding.LoanApp.entities;

import com.coding.LoanApp.enums.PaymentMode;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseEntity{
    private double amount ;
    // hard coding for now
    private PaymentMode paymentMode = PaymentMode.NEFT;
    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan ;
}
