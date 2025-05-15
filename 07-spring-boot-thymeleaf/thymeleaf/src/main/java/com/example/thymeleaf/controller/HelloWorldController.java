package com.example.thymeleaf.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // controller method to show the html form
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // a controller method to process the html form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // read form data with all caps
    @RequestMapping("/processFormAgain")
    public String shout(HttpServletRequest req, Model model) {

        // read the request from the html form
        String name = req.getParameter("firstName");

        // convert data to all caps
        name = name.toUpperCase();

        // create new message
        String result = "YO! " + name;

        // add message to model
        model.addAttribute("message", result);

        return "helloworld";
    }

    @GetMapping("/processFormVersion3")
    public String processFormVersion3(@RequestParam("firstName") String name, Model model) {

        // read the request from the html form
//        String name = req.getParameter("firstName");

        // convert data to all caps
        name = name.toUpperCase();

        // create new message
        String result = "YO BAI WHAT AH GWAN! " + name;

        // add message to model
        model.addAttribute("message", result);

        return "helloworld";
    }

}
