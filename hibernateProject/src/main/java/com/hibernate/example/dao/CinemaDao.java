package com.hibernate.example.dao;

import com.hibernate.example.SessionFactoryH2;
import com.hibernate.example.entities.Cinema;
import com.hibernate.example.entities.Movie;
import org.hibernate.Session;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.util.ArrayList;
import java.util.List;

public class CinemaDao {


    public Cinema findById(Integer id) {
        Session session = getSessionAndBeginTransaction();
        Cinema cinema = session.get(Cinema.class, id);
        session.getTransaction().commit();
        return cinema;
    }

    public List<Movie> findAllMoviesByCinemaId(Integer id) {
        Session session = getSessionAndBeginTransaction();
        List<Movie> movieList = new ArrayList<>(session.get(Cinema.class,id).getMovies());
        session.getTransaction().commit();
        return movieList;
    }

    public void addMovieToCinema(Integer id, Movie movie) {
        Session session = getSessionAndBeginTransaction();
        Cinema cinema = session.get(Cinema.class, id);
        cinema.getMovies().add(movie);
        session.getTransaction().commit();
    }


    public void addCinema(Cinema cinema) {
        Session session = getSessionAndBeginTransaction();
        session.persist(cinema);
        session.getTransaction().commit();
    }


    private Session getSessionAndBeginTransaction() {
        Session session = SessionFactoryH2.getSession();
        if (session.getTransaction().getStatus().equals(TransactionStatus.NOT_ACTIVE)) {
            session.beginTransaction();
        }
        return session;
    }
}
