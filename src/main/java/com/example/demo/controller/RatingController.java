package com.example.demo.controller;

import com.example.demo.school.Rating;
import com.example.demo.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/rating")
@RestController
public class RatingController {
    private final RatingService ratingService;

    @PostMapping
    public Rating postRating(@RequestBody Rating rating) {
        return ratingService.save(rating);
    }
}
