package com.example.demo.service;

import com.example.demo.exceptions.CourseNotFoundException;
import com.example.demo.repo.ClassRepository;
import com.example.demo.repo.RatingRepository;
import com.example.demo.school.Rating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    private final ClassRepository classRepository;

    public Rating save(Rating rating) {
        boolean courseExists = classRepository.existsById(rating.getCourse().getId());
        if (courseExists) {
            return ratingRepository.save(rating);
        } else {
            throw new CourseNotFoundException();
        }
    }
}
