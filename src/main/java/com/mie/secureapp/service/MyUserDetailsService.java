package com.mie.secureapp.service;

import com.mie.secureapp.model.Users;
import com.mie.secureapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if(user == null) {
            System.out.println("User not found!");
            throw new UsernameNotFoundException("User not found!");
        }

        System.out.println("User found!");
        return new UserPrinciple(user);
    }
}
