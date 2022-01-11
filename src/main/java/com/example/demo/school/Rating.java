package com.example.demo.school;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Rating {
    @Id
    @GeneratedValue
    private Long id;
    private int rating;
    @ManyToOne
    private Class course;
    private LocalDateTime date;
    private String comment;
}
