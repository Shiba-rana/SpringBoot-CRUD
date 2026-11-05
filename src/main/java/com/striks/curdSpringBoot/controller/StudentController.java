package com.striks.curdSpringBoot.controller;

import com.striks.curdSpringBoot.entity.Student;
import com.striks.curdSpringBoot.service.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    // Constructor Injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // CREATE STUDENT
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        Student createdStudent = studentService.createStudent(student);

        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    // READ STUDENT BY ID
    @GetMapping("/read/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {

        Student student = studentService.getStudent(id);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(student);
    }

    // READ ALL STUDENTS
    @GetMapping("/readAll")
    public ResponseEntity<List<Student>> readAllStudents() {

        List<Student> students = studentService.getAllStudents();

        return ResponseEntity.ok(students);
    }

    // UPDATE STUDENT
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody Student studentDetails) {

        Student updatedStudent =
                studentService.updateStudent(id, studentDetails);

        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedStudent);
    }

    // PERMANENT DELETE STUDENT
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {

        Student deletedStudent = studentService.deleteStudent(id);

        if (deletedStudent == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student not found with ID: " + id);
        }

        return ResponseEntity.ok("Student deleted successfully.");
    }

    // SOFT DELETE STUDENT
    @PatchMapping("/softDelete/{id}")
    public ResponseEntity<String> softDeleteStudent(@PathVariable Long id) {

        boolean isDeleted = studentService.softDeleteStudent(id);

        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Student not found with ID: " + id);
        }

        return ResponseEntity.ok("Student soft deleted successfully.");
    }
}