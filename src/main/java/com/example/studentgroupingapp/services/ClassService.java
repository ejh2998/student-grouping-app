package com.example.studentgroupingapp.services;


import com.example.studentgroupingapp.entity.ClassOfStudents;
import com.example.studentgroupingapp.repos.ClassOfStudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    @Autowired
    private ClassOfStudentsRepository classOfStudentsRepository;

    public List<ClassOfStudents> getAllClasses() {
        return classOfStudentsRepository.findAll();
    }

    public Optional<ClassOfStudents> getClassById(Long id) {
        return classOfStudentsRepository.findById(id);
    }

    public ClassOfStudents saveClass(ClassOfStudents newClass) {
        return classOfStudentsRepository.save(newClass);
    }
    public void deleteClassById(Long id) {
        classOfStudentsRepository.deleteById(id);
    }
}
