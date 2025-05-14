package com.project.loanOriginationManagementSystem.Entity;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;

import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Generated
@Data
@Entity
@Table(name = "coborrower")
public class CoBorrower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "co_borrower_id")
    private Long coBorrowerId;

    @ManyToOne
    @JoinColumn(name = "borrower_id", nullable = false)
    private Borrower borrower;

    @Column(name = "co_borrower_type", nullable = false)
    private String coBorrowerType;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "business_name", nullable = false)
    private String businessName;

    @Column(name = "national_id_number", nullable = false)
    private String nationalIdNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "relationship_to_borrower", nullable = false)
    private String relationshipToBorrower;

    @Timestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate = LocalDateTime.now();;

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate = LocalDateTime.now();


}
