package com.example.studentgroupingapp.repos;

import com.example.studentgroupingapp.entity.TableAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TableAssignmentRepository extends JpaRepository<TableAssignment, Long> {
    List<TableAssignment> findByClassId(Long classId);
}
