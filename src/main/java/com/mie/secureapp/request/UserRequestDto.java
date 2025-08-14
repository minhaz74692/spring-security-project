package com.mie.secureapp.request;

import lombok.Data;

@Data
public class UserRequestDto {
    private String username;
    private String password;
    // private String role; // Uncomment if you want to include role in the request
}
