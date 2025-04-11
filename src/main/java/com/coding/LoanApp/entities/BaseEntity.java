package com.coding.LoanApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    private String id = UUID.randomUUID().toString();
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt ;
    // hard coding for one intent is to keep audit
    private String createdBy = "first_officer@xyz.com" ;
    private String updateBy = "second_officer@xyx.com" ;
}
