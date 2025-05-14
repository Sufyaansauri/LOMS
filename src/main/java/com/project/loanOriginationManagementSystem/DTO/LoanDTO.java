package com.project.loanOriginationManagementSystem.DTO;

import com.project.loanOriginationManagementSystem.Entity.Borrower;
import com.project.loanOriginationManagementSystem.Entity.LoanProduct;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Generated
@Data
@Builder
public class LoanDTO {

    private Long borrowerId;

    private Long loanProductId;

    private BigDecimal principalAmount;

    private BigDecimal interestRate;

    private Integer tenureMonths;

    private LocalDateTime disbursalDate;

    private String status = "Active";

    private Boolean hasCoBorrowers = false;

    private Boolean totalLiabilitySplit = false;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

}
