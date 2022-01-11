package com.example.demo.service;

import com.example.demo.exceptions.CourseNotFoundException;
import com.example.demo.exceptions.StudentNotFoundException;
import com.example.demo.repo.ClassRepository;
import com.example.demo.repo.GradeRepository;
import com.example.demo.repo.StudentRepository;
import com.example.demo.school.Class;
import com.example.demo.school.Grade;
import com.example.demo.school.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final GradeRepository gradeRepository;

    public Student save(Student student) {
        List<Long> courses = Optional.of(student.getCourses())
                .orElse(List.of())
                .stream()
                .map(Class::getId)
                .collect(Collectors.toList());
        boolean coursesExistAndHaveFreeSpace = classRepository.allExistAndHaveFreeSpace(courses, courses.size());
        if (coursesExistAndHaveFreeSpace) {
            return studentRepository.save(student);
        } else {
            throw new CourseNotFoundException();
        }
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(StudentNotFoundException::new);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    public double getAverageGrade(Long studentId, Long courseId) {
        Student student = studentRepository
                .findById(studentId)
                .orElseThrow(StudentNotFoundException::new);

        OptionalDouble average = student
                .getGrades().stream()
                .filter(grade -> grade.getCourse().getId().equals(courseId))
                .mapToDouble(Grade::getGrade)
                .average();

        return average.orElseThrow();
    }

    public String getStudentsAsCsv() {
        return "";
    }
}
