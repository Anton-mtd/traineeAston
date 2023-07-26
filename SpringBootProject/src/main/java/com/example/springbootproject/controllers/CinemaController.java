package com.example.springbootproject.controllers;

import com.example.springbootproject.dto.CinemaDto;
import com.example.springbootproject.entity.Cinema;
import com.example.springbootproject.repository.CinemaRepository;
import com.example.springbootproject.services.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CinemaController {

    private final CinemaService cinemaService;

    @GetMapping("/cinema{id}")
    public CinemaDto get(@PathVariable Integer id){
        CinemaDto cd = cinemaService.getCinemaById(id);
       return cd;
    }

    @PostMapping("/add")
    public void addOrModify(@RequestBody Cinema cinema) {
        cinemaService.addOrModifyCinema(cinema);
    }
}
