package com.striks.curdSpringBoot.controller;

import com.striks.curdSpringBoot.entity.Student;
import com.striks.curdSpringBoot.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

        if( student == null ) {
            System.out.println("Student not found with ID: " + id);
        }
        return student;
    }

    // Read All
    @GetMapping("/readAll")
    public List<Student> readAllStudents() {
        // Implementation for reading all students
        if( studentService.getAllStudents().isEmpty()) {
            // Handle empty list case
            System.out.println("No students found in the database.");
        }
        return studentService.getAllStudents();
    }

    // Update
    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }

    // Delete
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
