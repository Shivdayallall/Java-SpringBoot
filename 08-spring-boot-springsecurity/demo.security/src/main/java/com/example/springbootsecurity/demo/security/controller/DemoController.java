package com.example.springbootsecurity.demo.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }



    // mapping for leaders
    @GetMapping("/leaders")
    public String showLeaders() {
        return "leaders";
    }


    // mapping for leaders
    @GetMapping("/admin")
    public String showAdmin() {
        return "admin";
    }

}
