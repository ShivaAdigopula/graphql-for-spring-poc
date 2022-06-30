package com.albathanext.graphqlforspringpoc.repository;

import com.albathanext.graphqlforspringpoc.exception.DataNotFoundException;
import com.albathanext.graphqlforspringpoc.model.Movie;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
    private final List<Movie> movies = new ArrayList<Movie>();

    @Override
    public Movie save(Movie movie) {
        movie.setId(movies.size() + 1);
        movies.add(movie);
        return movie;
    }

    @Override
    public List<Movie> findAll() {
        return movies;
    }

    @Override
    public Movie findByُُُTitle(String title) {
        return movies.stream()
                .filter(movie -> movie.getTitle().equals(title))
                .findFirst().orElseThrow(() -> new DataNotFoundException("Movie Not Found"));
    }

    @PostConstruct
    private void init() {
        movies.add(new Movie(1, "abc", "abc.jpg"));
        movies.add(new Movie(2, "def", "def.jpg"));
        movies.add(new Movie(3, "ghi", "ghi.jpg"));
        movies.add(new Movie(4, "jkl", "jkl.jpg"));

    }
}
