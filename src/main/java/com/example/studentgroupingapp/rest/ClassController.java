package com.example.studentgroupingapp.rest;

import com.example.studentgroupingapp.entity.ClassOfStudents;
import com.example.studentgroupingapp.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping
    public List<ClassOfStudents> getAllClasses() {
        return classService.getAllClasses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassOfStudents> getClassById(@PathVariable Long id) {
        Optional<ClassOfStudents> optionalClass = classService.getClassById(id);
        return optionalClass.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClassOfStudents createClass(@RequestBody ClassOfStudents newClass) {
        return classService.saveClass(newClass);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClassOfStudents> deleteClass(@PathVariable Long id) {
        classService.deleteClassById(id);
        return ResponseEntity.ok().build();
    }
}
