package com.albathanext.graphqlforspringpoc.controller;

import com.albathanext.graphqlforspringpoc.model.Movie;
import com.albathanext.graphqlforspringpoc.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class MovieController {
    private MovieService movieService;

    @SchemaMapping(typeName = "Query", value = "movies")
    public Iterable<Movie> findMovies(@Argument String title){
         return movieService.findMovies(title);
    }

    @MutationMapping
    public Movie createMovie(@Argument Movie movie){
        return movieService.save(movie);
    }
}
