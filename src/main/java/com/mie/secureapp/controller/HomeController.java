package com.mie.secureapp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public  String getHomePage(HttpServletRequest httpServletRequest){
        return  "This is home : "+ httpServletRequest.getSession().getId();
    }

}
