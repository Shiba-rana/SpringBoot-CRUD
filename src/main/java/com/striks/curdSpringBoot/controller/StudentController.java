package com.striks.curdSpringBoot.controller;

import com.striks.curdSpringBoot.entity.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    // Create
    @PostMapping("/create")
    public void createStudent(@RequestBody Student student) {
        System.out.println("Student Email: " + student.getEmail() + "\n");
        System.out.println("Student Age: " + student.getAge() + "\n");
        System.out.println("Student Roll No: " + student.getRollNo() + "\n");
        System.out.println("Student Subject: " + student.getSubject() );
     }

    // Read
    @RequestMapping("/read/{id}")
    public void readStudent() {
    }

    // Update
    @RequestMapping("/update/{id}")
    public void updateStudent() {
    }

    // Delete
    @RequestMapping("/delete/{id}")
    public void deleteStudent() {
    }
}
