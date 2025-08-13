package com.mie.secureapp.controller;

import com.mie.secureapp.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    List<Student> students = new ArrayList<>(List.of(
            new Student(1,"minhaz", 28),
            new Student(2, "Monir", 30)
    ));

    @GetMapping("get-csrf")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("all")
    public List<Student> getStudents(){
        return  students;
    }

    @PostMapping("create")
    public  Student addStudent(@RequestBody Student s){
        students.add(s);
        return  s;
    }
}
