package com.project.loanOriginationManagementSystem.Service;

import com.project.loanOriginationManagementSystem.Entity.Roles;
import com.project.loanOriginationManagementSystem.Entity.Users;
import com.project.loanOriginationManagementSystem.Repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Timestamp;
import java.util.List;

@Service
public class RolesService {

    @Autowired
    private RolesRepository rolesRepository;

    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    public Roles getRoleById(Long id) {
        return rolesRepository.findById(id).orElse(null);
    }

    public Roles createRole(Roles role) {
        return rolesRepository.save(role);
    }

    public Roles updateRole(Long roleId, Roles roleDetails) {
        Roles existingRole = rolesRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + roleId));
        existingRole.setRoleName(roleDetails.getRoleName());
        existingRole.setDescription(roleDetails.getDescription());
        return rolesRepository.save(existingRole);
    }


    public void deleteRole(Long id) {
        rolesRepository.deleteById(id);
    }
}