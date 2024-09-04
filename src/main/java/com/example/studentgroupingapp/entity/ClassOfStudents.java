package com.example.studentgroupingapp.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ClassOfStudents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "classOfStudents", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
