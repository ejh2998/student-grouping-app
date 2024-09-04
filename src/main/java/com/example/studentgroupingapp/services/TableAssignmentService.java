package com.example.studentgroupingapp.services;

import com.example.studentgroupingapp.entity.TableAssignment;
import com.example.studentgroupingapp.repos.TableAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TableAssignmentService {

    @Autowired
    private TableAssignmentRepository tableAssignmentRepository;

    public List<TableAssignment> getAssignmentsByClassId(Long classId){
        return tableAssignmentRepository.findByClassId(classId);
    }

    public Optional<TableAssignment> getAssignmentById(Long id){
        return tableAssignmentRepository.findById(id);
    }

    public TableAssignment saveAssignment(TableAssignment assignment){
        return tableAssignmentRepository.save(assignment);
    }

    public void deleteAssignmentById(Long id){
        tableAssignmentRepository.deleteById(id);
    }
}
