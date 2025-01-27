package com.example.restAPI.restController.rest;

import com.example.restAPI.restController.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private final View error;
    private List<Student> theStudents;

    public StudentRestController(View error) {
        this.error = error;
    }

    // define  a postconstruct to load the student data only once

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<Student>();
        theStudents.add(new Student("Max", "load"));
        theStudents.add(new Student("Jack", "willson"));
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

        // check the student id against the list size
        if((studentID >= theStudents.size()) || (studentID < 0)) {
            throw new StudentNotFound("Student not found " + studentID);
        }

        return theStudents.get(studentID);
    }




}
