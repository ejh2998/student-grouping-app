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
    @JoinColumn(name = "class_id")
    private Class theClass;

    @ElementCollection
    private List<String> cannotSitWith;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getTheClass() {
        return theClass;
    }

    public void setTheClass(Class theClass) {
        this.theClass = theClass;
    }

    public List<String> getCannotSitWith() {
        return cannotSitWith;
    }

    public void setCannotSitWith(List<String> cannotSitWith) {
        this.cannotSitWith = cannotSitWith;
    }
}
