package com.project.loanOriginationManagementSystem.DTO;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
@Generated
@Data
public class UserRoleDTO {

    private Long userId;
    private Long roleId;
    private LocalDateTime assignedAt;
}
