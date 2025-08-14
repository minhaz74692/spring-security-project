package com.mie.secureapp.controller;

import com.mie.secureapp.model.Users;
import com.mie.secureapp.request.UserRequestDto;
import com.mie.secureapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public Users registerUser(@RequestBody UserRequestDto userDTO){
       return userService.register(userDTO);
    }
}
