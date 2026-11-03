package com.striks.curdSpringBoot.controller;

import com.striks.curdSpringBoot.entity.Student;
import com.striks.curdSpringBoot.service.StudentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {

//        System.out.println("Student Email: " + student.getEmail() + "\n");
//        System.out.println("Student Age: " + student.getAge() + "\n");
//        System.out.println("Student Roll No: " + student.getRollNo() + "\n");
//        System.out.println("Student Subject: " + student.getSubject() );

        System.out.println("Inside StudentController.createStudent() method");
        Student createdStudent = studentService.createStudent(student);
        return createdStudent;

        // return studentService.createStudent(student);
     }

     // Read one
    @GetMapping("/read/{id}")
    public Student getStudent(@PathVariable Long id) {
        Student student = studentService.getStudent(id);
        return student;
    }

    // Read
    @GetMapping("/read")
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
