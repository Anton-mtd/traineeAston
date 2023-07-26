package com.example.springbootproject.repository;

import com.example.springbootproject.entity.Cinema;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CinemaRepository extends JpaRepository<Cinema, Integer> {


    @EntityGraph(value = "cinema-entity-graph")
    Optional<Cinema> findById(Integer id);
}
