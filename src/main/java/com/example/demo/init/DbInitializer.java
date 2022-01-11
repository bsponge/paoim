package com.example.demo.init;

import com.example.demo.repo.ClassRepository;
import com.example.demo.repo.GradeRepository;
import com.example.demo.repo.RatingRepository;
import com.example.demo.repo.StudentRepository;
import com.example.demo.school.Class;
import com.example.demo.school.Grade;
import com.example.demo.school.Student;
import com.example.demo.school.StudentCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class DbInitializer implements ApplicationRunner {
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final RatingRepository ratingRepository;
    private final GradeRepository gradeRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) {
        List<Class> courses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Class course = Class.builder()
                    .name("Course"+i)
                    .maxNumberOfStudents(10+i)
                    .build();
            course = classRepository.save(course);
            course.setStudents(new ArrayList<>());
            courses.add(course);
        }

        for (int i = 0; i < courses.size(); i++) {
            for (int j = 0; j < 6; j++) {
                List<Grade> grades = new ArrayList<>();

                Student student = Student.builder()
                        .name("Name"+j+i)
                        .surname("Surname"+j+i)
                        .birthYear(2000+i+j)
                        .points(j+i)
                        .studentCondition(StudentCondition.ODRABIAJACY)
                        .courses(List.of(courses.get(i)))
                        .build();

                for (int k = 0; k < 4; k++) {
                    Grade grade = Grade.builder()
                            .grade(k+1)
                            .course(courses.get(i))
                            .student(student)
                            .build();
                    grades.add(grade);
                }

                student.setGrades(grades);
                student = studentRepository.save(student);
                courses.get(i).getStudents().add(student);
            }
        }

        classRepository.saveAll(courses);
    }
}

