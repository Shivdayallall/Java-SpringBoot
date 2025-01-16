package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
    // Expose the endpoint to the browser
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World from the hello world controller";
    }

}
