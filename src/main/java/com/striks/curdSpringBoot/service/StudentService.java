package com.striks.curdSpringBoot.service;

import com.striks.curdSpringBoot.entity.Student;
import com.striks.curdSpringBoot.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Component
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent( Student studentReq) {
//        return studentRepository.saveStudent(studentReq);

        Student studentRes = studentRepository.save(studentReq);
        return studentRes;
    }

    public Student getStudent(Long id) {

        // #1
        Student studentRes = studentRepository.findById(id).orElse(null);
        return studentRes;

        // #2
        // return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
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

    public Student deleteStudent(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student == null) {
            return null;
        }
        studentRepository.delete(student);
        return student;
    }
}
