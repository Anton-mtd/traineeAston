package com.example.springbootproject.converters;

import com.example.springbootproject.dto.MovieDto;
import com.example.springbootproject.entity.Movie;

import java.util.stream.Collectors;


public class MovieConverter {

    public static MovieDto movieToDtoMovie(Movie movie) {
        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .ratingDto(RatingConverter.ratingToDtoRating(movie.getRating()))
                .build();
    }

    public static Movie movieDtoToMovie(MovieDto movieDto) {
        return Movie.builder()
                .id(movieDto.getId())
                .title(movieDto.getTitle())
                .cinemas(movieDto.getCinemas().stream().map(CinemaConverter::cinemaDtoToCinema).collect(Collectors.toSet()))
                .build();
    }
}
