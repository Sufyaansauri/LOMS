package com.project.loanOriginationManagementSystem.Controller;


import com.project.loanOriginationManagementSystem.Entity.Roles;
import com.project.loanOriginationManagementSystem.Service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class  RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping
    public List<Roles> getAllRoles() {
        return rolesService.getAllRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roles> getRoleById(@PathVariable Long id) {
        Roles role = rolesService.getRoleById(id);
        return role != null ? ResponseEntity.ok(role) : ResponseEntity.notFound().build();
    }

    @PostMapping("/createRole")
    public ResponseEntity<Roles> createRole(@RequestBody Roles role) {
        Roles createdRole = rolesService.createRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Roles> updateRole(@PathVariable Long id, @RequestBody Roles roleDetails) {
        Roles updatedRole = rolesService.updateRole(id, roleDetails);
        return updatedRole != null ? ResponseEntity.ok(updatedRole) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        rolesService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}