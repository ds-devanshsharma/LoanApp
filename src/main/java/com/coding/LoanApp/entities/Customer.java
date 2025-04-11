package com.coding.LoanApp.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@Entity
public class Customer extends BaseEntity{

    private String name ;
    private String email ;
    private LocalDateTime dob ;
    private String aadhaar;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL )
    private List<Loan> loans;
}
