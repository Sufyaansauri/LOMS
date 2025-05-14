package com.project.loanOriginationManagementSystem.DTO;

import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Generated
@Data
@Builder
public class CoBorrowerResponseDTO {


    private Long coBorrowerId;

    private Long borrowerId;

    private String coBorrowerType;

    private String firstName;

    private String lastName;

    private String businessName;

    private String nationalIdNumber;

    private String email;

    private String phone;

    private String address;

    private String relationshipToBorrower;

    private LocalDateTime creationDate ;

    private LocalDateTime lastModifiedDate ;

}
