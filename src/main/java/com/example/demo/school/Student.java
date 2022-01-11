package com.example.demo.school;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private int birthYear;
    private double points;
    private StudentCondition studentCondition;
    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private List<Class> courses;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Grade> grades = new ArrayList<>();
}
