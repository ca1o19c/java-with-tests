package com.learning.javawithtests.domain;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Rent {

    private User user;
    private List<Movie> movies;
    private Date rentDate;
    private Date returnDate;
    private Double value;

    public User getUser() {
        return user;
    }

    public Rent setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public Rent setMovies(List<Movie> movies) {
        this.movies = movies;
        return this;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public Rent setRentDate(Date rentDate) {
        this.rentDate = rentDate;
        return this;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public Rent setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Rent setValue(Double value) {
        this.value = value;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return Objects.equals(user, rent.user) && Objects.equals(movies, rent.movies) && Objects.equals(rentDate, rent.rentDate) && Objects.equals(returnDate, rent.returnDate) && Objects.equals(value, rent.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, movies, rentDate, returnDate, value);
    }

    @Override
    public String toString() {
        return "Rent{" +
                "user=" + user +
                ", movies=" + movies +
                ", rentDate=" + rentDate +
                ", returnDate=" + returnDate +
                ", value=" + value +
                '}';
    }
}
