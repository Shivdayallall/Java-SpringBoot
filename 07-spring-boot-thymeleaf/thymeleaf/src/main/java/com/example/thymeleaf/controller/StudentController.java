package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${programmingLanguage}")
    private List<String> programmingLanguage;

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {
        // create a student object
        Student theStudent = new Student();

        // add students object to the model
        theModel.addAttribute("student", theStudent);

        // add countries to the form
        theModel.addAttribute("countries", countries);

        // add the programming languages to the form
        theModel.addAttribute("programmingLanguage", programmingLanguage);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {
        System.out.println(theStudent.getFirstName() + " " + theStudent.getLastName());
        return "form-submitted";
    }

}
