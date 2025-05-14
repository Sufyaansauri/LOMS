package com.project.loanOriginationManagementSystem.Controller;

import com.project.loanOriginationManagementSystem.DTO.UserRoleDTO;
import com.project.loanOriginationManagementSystem.Entity.UserRoles;
import com.project.loanOriginationManagementSystem.Service.UserRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userRoles")
public class UserRolesController {

    @Autowired
    private UserRolesService userRolesService;
//
//    @GetMapping
//    public List<UserRoles> getAllUserRoles() {
//        List<UserRoles> userRoles = userRolesService.getAllUserRoles();
//        System.out.println("Response UserRoles: " + userRoles);  // Debug log
//        return userRoles;
//    }

    @GetMapping
    public ResponseEntity<?> getAllUserRoles() {
        List<UserRoles> rolesList = userRolesService.getAllUserRoles();
        return ResponseEntity.ok(rolesList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRoles> getUserRoleById(@PathVariable Long id) {
        return userRolesService.getUserRoleById(id)
                .map(role -> ResponseEntity.ok(role))
                .orElse(ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public ResponseEntity<UserRoles> createUserRole(@RequestBody UserRoles userRole) {
//        UserRoles createdUserRole = userRolesService.createUserRole(userRole);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserRole);
//    }

    @PostMapping
    public ResponseEntity<UserRoles> createUserRole(@RequestBody UserRoleDTO userRoleDTO) {

        UserRoles userRole = userRolesService.createUserRole(userRoleDTO);

        return ResponseEntity.status(201).body(userRole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRoles> updateUserRole(@PathVariable Long id, @RequestBody UserRoleDTO userRole) {
        UserRoles updatedUserRole = userRolesService.updateUserRole(id, userRole);
        return ResponseEntity.status(201).body(updatedUserRole);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable Long id) {
        userRolesService.deleteUserRole(id);
        return ResponseEntity.noContent().build();
    }
}

