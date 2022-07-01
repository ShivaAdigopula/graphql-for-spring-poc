package com.albathanext.graphqlforspringpoc.controller;

import com.albathanext.graphqlforspringpoc.model.Movie;
import com.albathanext.graphqlforspringpoc.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Slf4j
@GraphQlTest(MovieController.class)
 class MovieControllerTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @MockBean
    private MovieService movieService;

    private final List<Movie> movies = new ArrayList<>();

    @BeforeEach
    void setUp(){
        movies.add(new Movie(1, "abc", "abc.jpg"));
        movies.add(new Movie(2, "def", "def.jpg"));
        movies.add(new Movie(3, "ghi", "ghi.jpg"));
        movies.add(new Movie(4, "jkl", "jkl.jpg"));
    }

    @Test
    public void contextLoads() {
        assertNotNull(graphQlTester);
        assertNotNull(movieService);
    }

    @Test
    void testMoviesQueryWithNoFilterReturnsAllMovies() {


        when(movieService.findMovies(null)).thenReturn(movies);

        graphQlTester.documentName("movies")
                .variable("title", null)
                .execute()
                .path("movies")
                .entityList(Movie.class)
                .hasSize(4);
    }

    @Test
    void testMoviesQueryWithFilterReturnsAllMovies() {
        final String title = "abc";

        when(movieService.findMovies(title)).thenReturn(movies.stream().filter(movie -> movie.getTitle().equals(title)).collect(Collectors.toList()));

        graphQlTester.documentName("movies")
                .variable("title", title)
                .execute()
                .path("movies")
                .entityList(Movie.class)
                .hasSize(1);
    }
}