package com.example.restAPI.restController.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    // add exception handler for invalid ID
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFound(StudentNotFound studentNotFound) {
        // create a student error
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(studentNotFound.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        // return response error
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    // add exception handler for all request generic exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {

        // create a student error
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        // return response error
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);


    }

}
