package com.example.springbootproject.converters;

import com.example.springbootproject.dto.MovieDto;
import com.example.springbootproject.dto.RatingDto;
import com.example.springbootproject.entity.Movie;
import com.example.springbootproject.entity.Rating;

public class RatingConverter {

    public static RatingDto ratingToDtoRating(Rating rating) {
        return RatingDto.builder()
                .id(rating.getId())
                .title(rating.getTitle())
                .build();
    }
}
