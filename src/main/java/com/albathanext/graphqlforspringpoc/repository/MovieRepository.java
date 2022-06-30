package com.albathanext.graphqlforspringpoc.repository;

import com.albathanext.graphqlforspringpoc.model.Movie;

import java.util.List;

public interface MovieRepository {
    Movie save(Movie movie);
    List<Movie> findAll();
    Movie findByُُُTitle(String title);
}
