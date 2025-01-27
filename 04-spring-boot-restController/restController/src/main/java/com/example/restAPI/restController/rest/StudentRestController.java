package com.example.restAPI.restController.rest;

import com.example.restAPI.restController.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define a endpoint for students and return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudents = new ArrayList<Student>();
        theStudents.add(new Student("Max", "load"));
        theStudents.add(new Student("Jack", "willsen"));
        theStudents.add(new Student("John", "nest"));

        // jackson will convert the code to json by automatically
        return theStudents;
    }
}
