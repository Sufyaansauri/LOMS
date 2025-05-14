package com.project.loanOriginationManagementSystem.Entity;


import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Generated
@Data
@Entity
@Table(name = "loanproduct")
public class LoanProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_product_id")
    private Long loanProductId;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "interest_rate", unique = true, nullable = false)
    private String interestRate;

    @Column(name = "max_tenure_months")
    private String maxTenureMonths;

    @Column(name = "allow_co_borrowers")
    private boolean allowCoBorrowers;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate = LocalDateTime.now();

    @LastModifiedDate
    @Timestamp
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate = LocalDateTime.now();



}
