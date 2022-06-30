package com.albathanext.graphqlforspringpoc.controller;

import com.albathanext.graphqlforspringpoc.model.MovieBooking;
import com.albathanext.graphqlforspringpoc.service.MovieBookingService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class MovieBookingController {
    private MovieBookingService movieBookingService;

    @SchemaMapping(typeName = "Query", value="movieBookings")
    public Iterable<MovieBooking> findMovieBookings(@Argument String email) {
        return movieBookingService.findMovieBookings(email);
    }

    @MutationMapping
    public MovieBooking createMovieBooking(@Argument MovieBooking movieBooking) {
        return movieBookingService.save(movieBooking);
    }
}
