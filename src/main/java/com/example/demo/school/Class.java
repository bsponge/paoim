package com.example.demo.school;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Class {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int maxNumberOfStudents;
    @ManyToMany
    @JsonIgnore
    private List<Student> students;
}
