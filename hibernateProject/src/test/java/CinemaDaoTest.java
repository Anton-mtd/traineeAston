import com.hibernate.example.SessionFactoryH2;
import com.hibernate.example.dao.CinemaDao;
import com.hibernate.example.entities.Address;
import com.hibernate.example.entities.Cinema;
import com.hibernate.example.entities.Movie;
import com.hibernate.example.entities.Rating;
import org.hibernate.Session;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.Set;

@DisplayName("CinemaDaoTest")
public class CinemaDaoTest {

    Session session = null;
    CinemaDao cinemaDao = new CinemaDao();

    @BeforeEach
    public void setup() {
        session = SessionFactoryH2.getSession();
        session.beginTransaction();
    }

    @Test
    public void testFindById() {
        Cinema expected = session.get(Cinema.class,1);
        session.getTransaction().commit();
        Cinema actual = cinemaDao.findById(1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindAllMoviesByCinemaId() {
        Set<Movie> expected = new HashSet<>(session.get(Cinema.class,1).getMovies());
        session.getTransaction().commit();
        Set<Movie> actual = new HashSet<>(cinemaDao.findAllMoviesByCinemaId(1));

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testAddMovieToCinema() {
        Movie movie = new Movie();
        movie.setTitle("NewMovie");
        movie.setRating(session.get(Rating.class,1));
        boolean containsBeforeAdd = session.get(Cinema.class,1).getMovies().contains(movie);
        Assumptions.assumeFalse(containsBeforeAdd);
        session.getTransaction().commit();

        cinemaDao.addMovieToCinema(1,movie);

        session = SessionFactoryH2.getSession();
        session.beginTransaction();
        boolean containsAfterAdd = session.get(Cinema.class,1).getMovies().contains(movie);
        session.getTransaction().commit();
        Assumptions.assumeTrue(containsAfterAdd);
    }


    @Test
    public void testAddCinema() {
        Address address = new Address();
        address.setStreet("Маяковского");
        address.setNumber(132);
        Cinema cinema = new Cinema();
        cinema.setTitle("newCinema");
        cinema.setAddress(address);

        cinemaDao.addCinema(cinema);

        session.getTransaction().commit();
        Assertions.assertEquals(cinemaDao.findById(6), cinema);
    }

    @AfterAll
    static void tearDown() {
        SessionFactoryH2.shutdown();
    }
}
