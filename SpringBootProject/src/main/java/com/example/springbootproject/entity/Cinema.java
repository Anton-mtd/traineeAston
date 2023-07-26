package com.example.springbootproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@NamedEntityGraph(
        name = "cinema-entity-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "address"),
                @NamedAttributeNode(value = "movies")
        }
)

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cinemas")
public class Cinema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
            @JoinTable(
                    name = "cinemas_movies",
                    joinColumns = {@JoinColumn(name = "cinema_id")},
                    inverseJoinColumns = {@JoinColumn(name = "movie_id")}
            )
    private Set<Movie> movies = new HashSet<>();

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", street=" + address.getStreet() +
                ", number=" + address.getNumber() +
                '}';
    }

}
