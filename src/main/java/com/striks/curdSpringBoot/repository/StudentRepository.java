package com.striks.curdSpringBoot.repository;

import com.striks.curdSpringBoot.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentRepository {

    public Student saveStudent(Student student) {
        // Logic to save the student to the database
        // For demonstration purposes, we'll just return the same student object
        System.out.println("Inside StudentRepository.saveStudent() method");
        return student;
    }
}
