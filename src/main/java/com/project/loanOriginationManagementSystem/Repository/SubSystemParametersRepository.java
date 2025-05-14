package com.project.loanOriginationManagementSystem.Repository;

import com.project.loanOriginationManagementSystem.Entity.SubSystemParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubSystemParametersRepository extends JpaRepository<SubSystemParameters, Long> {
}
