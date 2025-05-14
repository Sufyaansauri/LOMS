package com.project.loanOriginationManagementSystem.Service;

import com.project.loanOriginationManagementSystem.DTO.UserRoleDTO;
import com.project.loanOriginationManagementSystem.Entity.Roles;
import com.project.loanOriginationManagementSystem.Entity.UserRoles;
import com.project.loanOriginationManagementSystem.Entity.Users;
import com.project.loanOriginationManagementSystem.Repository.RolesRepository;
import com.project.loanOriginationManagementSystem.Repository.UserRolesRepository;
import com.project.loanOriginationManagementSystem.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRolesService {
    private final UserRolesRepository userRolesRepository;

    @Autowired
    public UserRolesService(UserRolesRepository userRolesRepository) {
        this.userRolesRepository = userRolesRepository;
    }

    public List<UserRoles> getAllUserRoles(){
        return userRolesRepository.findAll();
    }

//    public List<UserRoles> getAllUserRoles() {
//        List<UserRoles> userRoles = userRolesRepository.findAll();
//        System.out.println("Fetched UserRoles: " + userRoles);  // Debug log
//        return userRoles;
//    }

    public Optional<UserRoles> getUserRoleById(Long userRoleId){
        return userRolesRepository.findById(userRoleId);
    }


//    public UserRoles createUserRole(UserRoles userRole) {
//        return userRolesRepository.save(userRole);
//    }



    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private RolesRepository roleRepository;

    public UserRoles createUserRole(UserRoleDTO userRoleDTO) {
        // Fetch the user and role from the repositories
        Users user = userRepository.findById(userRoleDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Roles role = roleRepository.findById(userRoleDTO.getRoleId()).orElseThrow(() -> new RuntimeException("Role not found"));

        // Create a new UserRole
        UserRoles userRole = new UserRoles();
        userRole.setUser(user);
        userRole.setRole(role);
//        userRole.setAssignedAt(userRoleDTO.getAssignedAt());

        // Save the UserRole and return it
        return userRolesRepository.save(userRole);
    }



    public UserRoles updateUserRole(Long id, UserRoleDTO userRoleDetails) {
        // 1. Fetch the existing UserRole entry by its ID (user_role_id)
        UserRoles userRole = userRolesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserRole not found"));

        // 2. Fetch the new User based on the userId provided in the request body
        Users user = userRepository.findById(userRoleDetails.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 3. Fetch the new Role based on the roleId provided in the request body
        Roles role = roleRepository.findById(userRoleDetails.getRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        // 4. Set the new user object on the UserRoles entity
        userRole.setUser(user);

        // 5. Set the new role object on the UserRoles entity
        userRole.setRole(role);

        // 6. Optional: update the assignedAt time if it's present in the request
        if (userRoleDetails.getAssignedAt() != null) {
            userRole.setAssignedAt(userRoleDetails.getAssignedAt());
        }

        // 7. Save the updated UserRoles entity back to the database
        return userRolesRepository.save(userRole);
    }


    public void deleteUserRole(Long userRoleId) {
        userRolesRepository.deleteById(userRoleId);
    }

}
