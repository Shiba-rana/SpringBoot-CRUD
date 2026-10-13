package com.striks.curdSpringBoot.service;

import com.striks.curdSpringBoot.entity.Student;
import com.striks.curdSpringBoot.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent( Student studentReq) {
//        return studentRepository.saveStudent(studentReq);

        System.out.println("Inside StudentService.createStudent() method");

        Student studentRes = studentRepository.saveStudent(studentReq);
        return studentRes;
    }
}
