package com.striks.curdSpringBoot.repository;

import com.striks.curdSpringBoot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Fetch only active students (is_deleted = false)
    List<Student> findByDeleteFalse();

}