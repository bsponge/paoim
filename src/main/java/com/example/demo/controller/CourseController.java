package com.example.demo.controller;

import com.example.demo.school.Class;
import com.example.demo.school.Student;
import com.example.demo.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final ClassService classService;

    @GetMapping
    public List<Class> getCourses() {
        List<Class> courses =  classService.getCourses();
        return courses;
    }

    @PostMapping
    public Class postCourse(@RequestBody Class cls) {
        return classService.save(cls);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        classService.deleteById(id);
    }

    @GetMapping("/{id}/students")
    public List<Student> getStudents(@PathVariable Long id) {
        return classService.getStudents(id);
    }

    @GetMapping("{id}/fill")
    public double getFill(@PathVariable Long id) {
        return classService.getFill(id);
    }
}
