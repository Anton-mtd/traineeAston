package com.example.springbootproject.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AddressDto {

    private Integer id;


    private String street;


    private Integer number;


}
