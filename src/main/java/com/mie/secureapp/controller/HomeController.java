package com.mie.secureapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public  String getHomePage(){
        System.out.println("Home Page");
        return  "home.jsp";
    }

    @RequestMapping("/test")
    public  String testPage(){
        return  "test.html";
    }
}
