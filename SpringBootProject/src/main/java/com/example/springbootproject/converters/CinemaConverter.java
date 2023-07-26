package com.example.springbootproject.converters;

import com.example.springbootproject.dto.CinemaDto;
import com.example.springbootproject.dto.MovieDto;
import com.example.springbootproject.entity.Cinema;

import java.util.Set;
import java.util.stream.Collectors;

public class CinemaConverter {

    public static CinemaDto cinemaToDtoCinema(Cinema cinema) {
        return CinemaDto.builder()
                .id(cinema.getId())
                .title(cinema.getTitle())
                .addressDto(AddressConverter.AddressToAddressDto(cinema.getAddress()))
                .moviesDto(cinema.getMovies().stream().map(MovieConverter::movieToDtoMovie).collect(Collectors.toSet()))
                .build();
    }

    public static Cinema cinemaDtoToCinema(CinemaDto cinemaDto) {
        return Cinema.builder()
                .id(cinemaDto.getId())
                .title(cinemaDto.getTitle())
                .address(AddressConverter.AddressDtoToAddress(cinemaDto.getAddressDto()))
                .movies(cinemaDto.getMoviesDto().stream().map(MovieConverter::movieDtoToMovie).collect(Collectors.toSet()))
                .build();
    }
}
