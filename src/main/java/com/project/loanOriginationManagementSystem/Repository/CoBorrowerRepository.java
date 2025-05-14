package com.project.loanOriginationManagementSystem.Repository;

import com.project.loanOriginationManagementSystem.Entity.CoBorrower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoBorrowerRepository extends JpaRepository<CoBorrower,Long> {
}
