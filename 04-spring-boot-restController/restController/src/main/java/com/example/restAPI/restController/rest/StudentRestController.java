package com.example.restAPI.restController.rest;

import com.example.restAPI.restController.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define  a postconstruct to load the student data only once

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<Student>();
        theStudents.add(new Student("Max", "load"));
        theStudents.add(new Student("Jack", "willsen"));
        theStudents.add(new Student("John", "nest"));

    }

    // define an endpoint for students and return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

        // jackson will convert the code to json by automatically
        return theStudents;
    }

    // define an endpoint to return a student by an studentId
    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID) {
        // the path variable in argument MUST MATCH the GetMapping name variable

        return theStudents.get(studentID);
    }
}
