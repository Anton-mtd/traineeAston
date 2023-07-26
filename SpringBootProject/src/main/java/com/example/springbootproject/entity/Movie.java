package com.example.springbootproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @JoinColumn(name = "rating_id")
    @ManyToOne
    private Rating rating;

    @ManyToMany(mappedBy = "movies")
    private Set<Cinema> cinemas = new HashSet<>();


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating.getTitle();
    }

}
