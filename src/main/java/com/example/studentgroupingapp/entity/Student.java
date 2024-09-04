package com.example.studentgroupingapp.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "class_of_students_id")
    private ClassOfStudents classOfStudents;

    @ElementCollection
    private List<String> cannotSitWith;


    public String getName() {
        return name;
    }


    public List<String> getCannotSitWith() {
        return cannotSitWith;
    }

    public void setCannotSitWith(List<String> cannotSitWith) {
        this.cannotSitWith = cannotSitWith;
    }
}
