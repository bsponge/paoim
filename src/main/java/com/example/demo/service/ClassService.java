package com.example.demo.service;

import com.example.demo.repo.ClassRepository;
import com.example.demo.school.Class;
import com.example.demo.school.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClassService {
    private final ClassRepository classRepository;

    public List<Class> getCourse() {
        return classRepository.findAll();
    }

    public Class save(Class cls) {
        return classRepository.save(cls);
    }

    public void deleteById(Long id) {
        classRepository.deleteById(id);
    }

    public List<Student> getStudents(Long id) {
        return classRepository
                .findById(id)
                .map(Class::getStudents)
                .orElse(List.of());
    }

    public double getFill(Long id) {
        return 0;
    }

    public List<Class> getCourses() {
        return classRepository.findAll();
    }
}

