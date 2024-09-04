package com.example.studentgroupingapp.rest;

import com.example.studentgroupingapp.entity.TableAssignment;
import com.example.studentgroupingapp.services.TableAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignments")
public class TableAssignmentController {

    @Autowired
    private TableAssignmentService tableAssignmentService;

    @GetMapping("/class/{classId}")
    public List<TableAssignment> getAssignmentsByClassId(@PathVariable Long classId) {
        return tableAssignmentService.getAssignmentsByClassId(classId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableAssignment> getAssignmentById(@PathVariable Long id) {
        Optional<TableAssignment> optionalAssignment = tableAssignmentService.getAssignmentById(id);
        return optionalAssignment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TableAssignment createAssignment(@RequestBody TableAssignment assignment) {
        return tableAssignmentService.saveAssignment(assignment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        tableAssignmentService.deleteAssignmentById(id);
        return ResponseEntity.noContent().build();
    }

}
