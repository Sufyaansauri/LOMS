package com.project.loanOriginationManagementSystem.Service;

import com.project.loanOriginationManagementSystem.Entity.UserPrincipal;
import com.project.loanOriginationManagementSystem.Entity.Users;
import com.project.loanOriginationManagementSystem.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUsersDetailsService  implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = usersRepository.findByUsername(username);

        if (user == null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");

        }

        return new UserPrincipal(user);
    }


}
