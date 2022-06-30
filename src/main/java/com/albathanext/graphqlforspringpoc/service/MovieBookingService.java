package com.albathanext.graphqlforspringpoc.service;

import com.albathanext.graphqlforspringpoc.exception.FieldLevelException;
import com.albathanext.graphqlforspringpoc.model.MovieBooking;
import com.albathanext.graphqlforspringpoc.repository.MovieBookingRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieBookingService {
    private MovieBookingRepository movieBookingRepository;

    public MovieBooking save(@NotNull MovieBooking movieBooking) {
        validateMovieBooking(movieBooking);
        return movieBookingRepository.save(movieBooking);
    }

    private void validateMovieBooking(MovieBooking movieBooking) {
        if (movieBooking.getMovie() == null) {
            throw new FieldLevelException("Movie Details not found in the request!", "movie");
        }
    }

    public List<MovieBooking> findMovieBookings(String email) {
        if (StringUtils.hasText(email)) {
            return movieBookingRepository.findByEmail(email);
        }
        return movieBookingRepository.findALL();
    }
}
