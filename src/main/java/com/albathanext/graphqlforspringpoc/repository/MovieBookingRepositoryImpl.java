package com.albathanext.graphqlforspringpoc.repository;

import com.albathanext.graphqlforspringpoc.model.MovieBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.albathanext.graphqlforspringpoc.constants.MovieBookingStatus.BOOKED;

@Repository
public class MovieBookingRepositoryImpl implements MovieBookingRepository {
    @Autowired
    private MovieRepository movieRepository;
    private final List<MovieBooking> movieBookings = new ArrayList<>();


    @Override
    public MovieBooking save(MovieBooking movieBooking) {
        movieBooking.setId(movieBookings.size()+1);
        movieBooking.setStatus(BOOKED.getStatus());
        movieBookings.add(movieBooking);
        return movieBooking;
    }

    @Override
    public List<MovieBooking> findByEmail(String email) {
        return movieBookings.stream().filter(movieBooking -> movieBooking.getEmail().equals(email)).collect(Collectors.toList());
    }

    @Override
    public List<MovieBooking> findALL() {
        return movieBookings;
    }

    @PostConstruct
    private void init() {
        var movieBooking1 = MovieBooking.builder()
                .movie(movieRepository.findByُُُTitle("abc"))
                .id(1)
                .first_name("shiva")
                .last_name("adigopula")
                .date("19/07/2022")
                .number_of_seats(2)
                .email("shiva.adigopula@albathanext.com")
                .status(BOOKED.getStatus())
                .build();
        movieBookings.add(movieBooking1);
    }
}
