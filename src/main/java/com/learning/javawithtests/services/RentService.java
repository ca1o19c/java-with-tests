package com.learning.javawithtests.services;

import com.learning.javawithtests.domain.Movie;
import com.learning.javawithtests.domain.Rent;
import com.learning.javawithtests.domain.User;
import com.learning.javawithtests.exceptions.MovieOutOfStockException;
import com.learning.javawithtests.exceptions.RentException;

import java.util.Date;
import java.util.List;

import static com.learning.javawithtests.utils.DateUtils.addDays;

public class RentService {

    public Rent rentMovie(User user, List<Movie> movies) throws RentException, MovieOutOfStockException {

        if (movies == null || movies.isEmpty())
            throw new RentException("Empty movie");

        for (Movie movie : movies
        ) {
            if (movie.getStock() == 0) {
                throw new MovieOutOfStockException();
            }
        }

        if (user == null)
            throw new RentException("Empty user");

        Rent rent = new Rent();
        rent.setMovies(movies);
        rent.setUser(user);
        rent.setRentDate(new Date());

        Double totalValue = 0d;
        for (int i = 0; i < movies.size(); i++) {
            var movie = movies.get(i);
            Double moviePrice = movie.getRentPrice();

            switch (i) {
                case 2:
                    moviePrice = moviePrice * 0.75;
                    break;
                case 3:
                    moviePrice = moviePrice * 0.5;
                    break;
            }

            totalValue += moviePrice;
        }
        rent.setValue(totalValue);

        //Entrega no dia seguinte
        Date deliveryDate = new Date();
        deliveryDate = addDays(deliveryDate, 1);
        rent.setReturnDate(deliveryDate);

        //Salvando a locacao...
        //TODO adicionar método para salvar

        return rent;
    }
}
