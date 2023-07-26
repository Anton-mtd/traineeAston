package com.example.springbootproject.dto;

import com.example.springbootproject.entity.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Builder
public class RatingDto {


    private Integer id;


    private String title;

}
