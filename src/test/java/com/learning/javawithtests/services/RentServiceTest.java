package com.learning.javawithtests.services;

import com.learning.javawithtests.domain.Movie;
import com.learning.javawithtests.domain.Rent;
import com.learning.javawithtests.domain.User;
import com.learning.javawithtests.exceptions.MovieOutOfStockException;
import com.learning.javawithtests.exceptions.RentException;
import com.learning.javawithtests.utils.DateUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

public class RentServiceTest {
    private RentService rentService;
    private User user;

    @Before
    public void setup() {
        rentService = new RentService();
        user = new User("Caio");
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldRentMovie() {
        // Teste se divide em 3 etapas

        // Cenario - onde as variáveis serão inicializadas
        var movies = List.of(
                new Movie("Shang-chi", 2, 5.0));

        // Ação - onde invocamos o metódo será invocado
        Rent rent = null;
        try {
            rent = rentService.rentMovie(user, movies);
        } catch (RentException | MovieOutOfStockException e) {
            e.printStackTrace();
        }

        // Validação - onde coletaremos os resultados e validaremos
        var rentDate = rent.getRentDate();

        var value = rent.getValue();

        assertThat(value).isEqualTo(5.0);

        var date = new Date();
        var checkDeliveryDate = DateUtils.isSameDate(rentDate, date);

        assertThat(checkDeliveryDate).isTrue();

        var returnDate = rent.getReturnDate();
        date = DateUtils.getDateDifferenceDays(1);
        var checkDateReturn = DateUtils.isSameDate(returnDate, date);
        assertThat(checkDateReturn).isTrue();
    }

    @Test(expected = MovieOutOfStockException.class)
    public void shouldNotRentOutOfStockMovie() throws RentException, MovieOutOfStockException {
        // Cenario - onde as variáveis serão inicializadas
        var movies = List.of(
                new Movie("Shang-chi", 0, 5.0));

        // Ação - onde invocamos o metódo será invocado
        rentService.rentMovie(user, movies);
    }

    @Test
    public void shouldNotRentMovieWithoutUser() throws MovieOutOfStockException {
        var movies = List.of(
                new Movie("Shang-chi", 2, 5.0));

        try {
            rentService.rentMovie(null, movies);
            fail();
        } catch (RentException e) {
            assertThat(e.getMessage()).isEqualTo("Empty user");
        }
    }

    @Test
    public void shouldVerifyIfTheMovieIsEmpty() throws MovieOutOfStockException, RentException {
        exception.expect(RentException.class);
        exception.expectMessage("Empty movie");

        rentService.rentMovie(user, null);
    }

    @Test
    public void shouldHave75PercentOffTheThirdMovie() throws MovieOutOfStockException, RentException {
        var movies = List.of(
                new Movie("Shang-chi", 2, 4.0),
                new Movie("Spider-Man: No Way Home", 1, 4.0),
                new Movie("Doctor Strange in the Multiverse of Madness", 1, 4.0));

        var result = rentService.rentMovie(user, movies);

        assertThat(result.getValue()).isEqualTo(11d);
    }

    @Test
    public void shouldHave50PercentOffTheFourthMovie() throws MovieOutOfStockException, RentException {
        var movies = List.of(
                new Movie("Shang-chi", 2, 4.0),
                new Movie("Spider-Man: No Way Home", 1, 4.0),
                new Movie("Doctor Strange in the Multiverse of Madness", 1, 4.0),
                new Movie("Cobra Kai", 6, 4.0));

        var result = rentService.rentMovie(user, movies);

        assertThat(result.getValue()).isEqualTo(13d);
    }
}
