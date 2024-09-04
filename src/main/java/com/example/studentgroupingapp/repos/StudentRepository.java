package com.example.studentgroupingapp.repos;

import com.example.studentgroupingapp.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByClassOfStudents_id(Long classId);
}
