package com.project.loanOriginationManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Setter
@Generated
@Data
@Entity
@Table(name = "subsystemparameters")
public class SubSystemParameters {

    // Getters and Setters
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_param_id")
    private Long subParamId;


    @ManyToOne(fetch = FetchType.LAZY)  // LAZY to avoid loading unless needed
    @JoinColumn(name = "system_param_id", referencedColumnName = "parameter_id")
    private SystemParameters systemParameter;

    @Setter
    @Column(name = "key_column", nullable = false)
    private String keyColumn;

    @Setter
    @Column(nullable = false)
    private String value;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}