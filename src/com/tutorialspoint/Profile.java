package com.tutorialspoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Profile {
    @Autowired
    @Qualifier("student1")
    private Student student;

    public Profile() {
        System.out.println("Profile: Dentro del Constructor");
    }

    public void printAge(){
        System.out.println("Edad: " + student.getAge());
    }

    public void printName(){
        System.out.println("Nombre:" + student.getName());
    }
}
