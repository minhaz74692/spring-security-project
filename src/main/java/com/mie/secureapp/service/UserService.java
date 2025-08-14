package com.mie.secureapp.service;

import com.mie.secureapp.model.Users;
import com.mie.secureapp.repository.UserRepo;
import com.mie.secureapp.request.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public Users register(UserRequestDto user){
        Users existingUser = userRepo.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("User already exists with username: " + user.getUsername());
        }
        Users newUser = new Users();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        return  userRepo.save(newUser);
    }
}
