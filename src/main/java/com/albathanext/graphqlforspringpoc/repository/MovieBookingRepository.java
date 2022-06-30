package com.albathanext.graphqlforspringpoc.repository;

import com.albathanext.graphqlforspringpoc.model.MovieBooking;

import java.util.List;

public interface MovieBookingRepository {
    MovieBooking save(MovieBooking movieBooking);
    List<MovieBooking> findByEmail(String email);
    List<MovieBooking> findALL();
}
