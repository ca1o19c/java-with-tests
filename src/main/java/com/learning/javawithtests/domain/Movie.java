package com.learning.javawithtests.domain;

import java.util.Objects;

public class Movie {

    private String name;
    private Integer stock;
    private Double rentPrice;

    public Movie() {
    }

    public Movie(String name, Integer stock, Double rentPrice) {
        this.name = name;
        this.stock = stock;
        this.rentPrice = rentPrice;
    }

    public String getName() {
        return name;
    }

    public Movie setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getStock() {
        return stock;
    }

    public Movie setStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public Double getRentPrice() {
        return rentPrice;
    }

    public Movie setRentPrice(Double rentPrice) {
        this.rentPrice = rentPrice;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) && Objects.equals(stock, movie.stock) && Objects.equals(rentPrice, movie.rentPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stock, rentPrice);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", stock=" + stock +
                ", rentPrice=" + rentPrice +
                '}';
    }
}
