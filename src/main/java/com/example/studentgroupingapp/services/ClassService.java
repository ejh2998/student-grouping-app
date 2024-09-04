package com.example.studentgroupingapp.services;


import com.example.studentgroupingapp.repos.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    public Optional<Class> getClassById(Long id) {
        return classRepository.findById(id);
    }

    public Class saveClass(Class newClass) {
        return classRepository.save(newClass);
    }
    public void deleteClassById(Long id) {
        classRepository.deleteById(id);
    }
}
