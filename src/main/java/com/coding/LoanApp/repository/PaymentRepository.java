package com.coding.LoanApp.repository;

import com.coding.LoanApp.entities.Payment;
import com.coding.LoanApp.projection.PaymentProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
   // using projection to for selective fetch
    List<PaymentProjection> findByLoanId(String loanId);
}
