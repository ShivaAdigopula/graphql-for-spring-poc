package com.albathanext.graphqlforspringpoc.service;

import com.albathanext.graphqlforspringpoc.model.Movie;
import com.albathanext.graphqlforspringpoc.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private MovieRepository movieRepository;

    public List<Movie> findMovies(String title) {
        if (StringUtils.hasText(title)) {
            return Arrays.asList(movieRepository.findByُُُTitle(title));
        }
        return movieRepository.findAll();
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

}
