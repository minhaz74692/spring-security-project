package com.mie.secureapp.service;

import com.mie.secureapp.model.Users;
import com.mie.secureapp.repository.UserRepo;
import com.mie.secureapp.request.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final JWTService jwtService;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    @Autowired
    AuthenticationManager authenticationManager;

    public Users register(UserRequestDto user){
        Users existingUser = userRepo.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("User already exists with username: " + user.getUsername());
        }
        Users newUser = new Users();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return  userRepo.save(newUser);
    }

    public String login(UserRequestDto userDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
        if (authentication.isAuthenticated())
            return jwtService.getToken(userDTO.getUsername());

        return "failed";
    }
}
