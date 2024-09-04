package com.example.studentgroupingapp.services;

import com.example.studentgroupingapp.entity.ClassOfStudents;
import com.example.studentgroupingapp.entity.Student;
import com.example.studentgroupingapp.entity.TableAssignment;
import com.example.studentgroupingapp.repos.ClassOfStudentsRepository;
import com.example.studentgroupingapp.repos.StudentRepository;
import com.example.studentgroupingapp.repos.TableAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TableAssignmentService {

    @Autowired
    private TableAssignmentRepository tableAssignmentRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private ClassOfStudentsRepository classOfStudentsRepository;

    public List<TableAssignment> assignStudentsToTables(Long classId, int numTables, int studentsPerTable) {
        Optional<ClassOfStudents> optionalClass = classOfStudentsRepository.findById(classId);
        if (optionalClass.isEmpty()) {
            throw new IllegalArgumentException("Class with ID " + classId + " does not exist.");
        }
        ClassOfStudents assignedClass = optionalClass.get();

        List<Student> students = studentRepository.findByClassOfStudents_id(classId);
        List<TableAssignment> assignments = new ArrayList<>();

        // Initialize a map to track which students are assigned to which tables
        Map<Integer, List<Student>> tableMap = new HashMap<>();
        for (int i = 0; i < numTables; i++) {
            tableMap.put(i, new ArrayList<>());
        }

        // Shuffle the students list to randomize initial order
        Collections.shuffle(students);

        // Assign students to tables while respecting constraints
        for (Student student : students) {
            boolean assigned = false;

            // Try to find a valid table for the student
            for (int tableNum = 0; tableNum < numTables; tableNum++) {
                List<Student> table = tableMap.get(tableNum);

                // Check if adding this student violates the constraints
                if (table.size() < studentsPerTable && canSitWith(table, student)) {
                    table.add(student);
                    assignments.add(createTableAssignment(assignedClass, tableNum, student)); // Use the updated method
                    assigned = true;
                    break;
                }
            }

            // If the student could not be assigned to any table, reset and try again
            if (!assigned) {
                return assignStudentsToTables(classId, numTables, studentsPerTable);
            }
        }

        // Save the assignments to the repository
        tableAssignmentRepository.saveAll(assignments);
        return assignments;
    }

    private TableAssignment createTableAssignment(ClassOfStudents assignedClass, int tableNumber, Student student) {
        TableAssignment assignment = new TableAssignment();
        assignment.setAssignedClass(assignedClass);  // Updated method call
        assignment.setTableNumber(tableNumber);
        assignment.setStudent(student);
        return assignment;
    }

    private boolean canSitWith(List<Student> table, Student student) {
        for (Student s : table) {
            if (student.getCannotSitWith() != null && student.getCannotSitWith().contains(s.getName())) {
                return false;
            }
            if (s.getCannotSitWith() != null && s.getCannotSitWith().contains(student.getName())) {
                return false;
            }
        }
        return true;
    }

    public List<TableAssignment> getAssignmentsByClassId(ClassOfStudents classOfStudents) {
        return tableAssignmentRepository.findByAssignedClass(classOfStudents);
    }

    public Optional<TableAssignment> getAssignmentById(Long id) {
        return tableAssignmentRepository.findById(id);
    }

    public TableAssignment saveAssignment(TableAssignment assignment) {
        return tableAssignmentRepository.save(assignment);
    }

    public void deleteAssignment(Long id) {
        tableAssignmentRepository.deleteById(id);
    }
}
