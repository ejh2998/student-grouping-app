package com.example.studentgroupingapp.repos;

import com.example.studentgroupingapp.entity.ClassOfStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassOfStudentsRepository extends JpaRepository<ClassOfStudents, Long> {
}
