package com.example.studentgroupingapp.entity;

import jakarta.persistence.*;

@Entity
public class TableAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tableNumber;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "assigned_class_id")
    private ClassOfStudents assignedClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ClassOfStudents getAssignedClass() {
        return assignedClass;
    }

    public void setAssignedClass(ClassOfStudents assignedClass) {
        this.assignedClass = assignedClass;
    }

}
