package com.hibernate.example;


import com.hibernate.example.dao.CinemaDao;
import com.hibernate.example.entities.Cinema;
import com.hibernate.example.entities.Movie;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class main {
    public static void main(String[] args) {

        try {
            catchLazyException();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Метод catchLazyException закрывает сессию после получения Объекта Cinema, следовательно " +
                    "после закрытия мы не можем получить ассоциативные данные к другим таблицам/сущностям и ловим LazyInitializationException");
        }
    }

    public static void catchLazyException() {
        CinemaDao cinemaDao = new CinemaDao();
        Cinema cinema = cinemaDao.findById(3);
        SessionFactoryH2.shutdown();
        System.out.println(cinema.getMovies());
    }
}
