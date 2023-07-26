package com.example.springbootproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
public class MovieDto {

    private Integer id;

    private String title;

    private RatingDto ratingDto;

    private Set<CinemaDto> cinemas = new HashSet<>();
}
