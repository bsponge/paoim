package com.example.demo.controller;

import com.example.demo.exceptions.CourseNotFoundException;
import com.example.demo.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = {StudentNotFoundException.class })
    protected ResponseEntity<String> handleStudentNotFoundException(RuntimeException exception, WebRequest request) {
        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {CourseNotFoundException.class})
    protected ResponseEntity<String> handleCourseNotFoundException(RuntimeException exception, WebRequest request) {
        return new ResponseEntity<>("Course not found", HttpStatus.NOT_FOUND);
    }
}
