package com.mie.secureapp.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {

    private Integer id;

    private String name;
    private Integer age;

   public Student(Integer id, String name, Integer age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

}
