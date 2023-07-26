package com.example.springbootproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
public class CinemaDto{

    private Integer id;


    private String title;


    private AddressDto addressDto;


    private Set<MovieDto> moviesDto = new HashSet<>();

}
