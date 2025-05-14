package com.project.loanOriginationManagementSystem.Service;


import com.project.loanOriginationManagementSystem.Entity.Users;
import com.project.loanOriginationManagementSystem.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUserById(Long userId) {
        return usersRepository.findById(userId).orElse(null);
    }

    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    public Users updateUser(Long userId, Users user) {
        if (usersRepository.existsById(userId)) {
            user.setUserId(userId);
            return usersRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long userId) {
        usersRepository.deleteById(userId);
    }


    public String verify(Users user) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        user.getUsername(),user.getPasswordHash()
                ));
        if (authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());

        return "fail";

    }

}