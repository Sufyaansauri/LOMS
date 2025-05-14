package com.project.loanOriginationManagementSystem.Repository;

import com.project.loanOriginationManagementSystem.Entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<Borrower,Long> {
}
