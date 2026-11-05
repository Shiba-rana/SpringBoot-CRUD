package com.striks.curdSpringBoot.service;

import com.striks.curdSpringBoot.entity.Student;
import com.striks.curdSpringBoot.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Constructor Injection
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE STUDENT
    public Student createStudent(Student studentReq) {

        // New students are active by default
        studentReq.setDelete(false);

        return studentRepository.save(studentReq);
    }

    // READ STUDENT BY ID
    public Student getStudent(Long id) {

        return studentRepository.findById(id).orElse(null);
    }

    // READ ALL ACTIVE STUDENTS
    public List<Student> getAllStudents() {

        return studentRepository.findByDeleteFalse();
    }

    // UPDATE STUDENT
    public Student updateStudent(Long id, Student studentDetails) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null || student.getDelete()) {
            return null;
        }

        // Update student properties
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setAge(studentDetails.getAge());
        student.setRollNo(studentDetails.getRollNo());
        student.setSubject(studentDetails.getSubject());

        return studentRepository.save(student);
    }

    // PERMANENT DELETE STUDENT
    public Student deleteStudent(Long id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        studentRepository.delete(student);

        return student;
    }

    // SOFT DELETE STUDENT
    public boolean softDeleteStudent(Long id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null || student.getDelete()) {
            return false;
        }

        student.setDelete(true);

        studentRepository.save(student);

        return true;
    }
}