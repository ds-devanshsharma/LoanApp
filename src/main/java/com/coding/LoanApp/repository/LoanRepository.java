package com.coding.LoanApp.repository;

import com.coding.LoanApp.entities.Customer;
import com.coding.LoanApp.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, String> {
}
