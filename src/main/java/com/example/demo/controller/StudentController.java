package com.example.demo.controller;

import com.example.demo.school.Student;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/api/student")
@RestController
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/{studentId}/{courseId}/grade")
    public double getAverageGrade(@PathVariable Long studentId, @PathVariable Long courseId) {
        return studentService.getAverageGrade(studentId, courseId);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
    }

    @GetMapping("/csv")
    public String getStudentsAsCsv() {
        return studentService.getStudentsAsCsv();
    }
}
