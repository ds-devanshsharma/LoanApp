package com.coding.LoanApp.entities;

import com.coding.LoanApp.enums.LoanType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Loan extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private LoanType loanType ;
    private double loanAmount ;
    private double installmentAmount ;
    private int tenure ;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer ;
    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL )
    private List<Payment> payments ;
}
