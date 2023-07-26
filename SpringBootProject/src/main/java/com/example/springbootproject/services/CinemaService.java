package com.example.springbootproject.services;


import com.example.springbootproject.converters.CinemaConverter;
import com.example.springbootproject.dto.CinemaDto;
import com.example.springbootproject.entity.Cinema;
import com.example.springbootproject.repository.CinemaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    public CinemaDto getCinemaById(Integer id) {
        Cinema cinema = cinemaRepository.findById(id).orElseThrow(()-> new RuntimeException("something wrong"));
        return CinemaConverter.cinemaToDtoCinema(cinema);
    }

    public void addOrModifyCinema(Cinema cinema) {
        cinemaRepository.save(cinema);
    }
}
