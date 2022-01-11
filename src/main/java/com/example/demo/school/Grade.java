package com.example.demo.school;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Grade {
    @Id
    @GeneratedValue
    private Long id;
    private double grade;
    @ManyToOne
    private Class course;
    @ManyToOne
    private Student student;
}
