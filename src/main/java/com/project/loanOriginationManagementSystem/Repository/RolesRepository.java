package com.project.loanOriginationManagementSystem.Repository;

import com.project.loanOriginationManagementSystem.Entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface RolesRepository extends JpaRepository<Roles, Long> {

//        Roles findByRoleName(String roleName);

}
