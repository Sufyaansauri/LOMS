package com.project.loanOriginationManagementSystem.Repository;

import com.project.loanOriginationManagementSystem.Entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {

}