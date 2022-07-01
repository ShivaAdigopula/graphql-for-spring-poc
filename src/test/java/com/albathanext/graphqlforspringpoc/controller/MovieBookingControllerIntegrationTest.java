package com.albathanext.graphqlforspringpoc.controller;

import com.albathanext.graphqlforspringpoc.model.MovieBooking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.graphql.test.tester.WebGraphQlTester;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@AutoConfigureHttpGraphQlTester
class MovieBookingControllerIntegrationTest {
    @Autowired
    private WebGraphQlTester graphQlTester;

    @Test
    void queryMovieBookings() {
        GraphQlTester.Response response = this.graphQlTester.documentName("movieBookings")
                .execute();
        response.path("movieBookings").entityList(MovieBooking.class).hasSizeGreaterThan(0);
        response.path("movieBookings[0].email").entity(String.class).isEqualTo("shiva.adigopula@albathanext.com")
                .path("movieBookings[0].id").entity(String.class).isEqualTo("1");
    }

    @Test
    void queryMovieBookingsWithInvalidEmailId() {
        GraphQlTester.Response response = this.graphQlTester.documentName("movieBookings")
                .variable("email", "test@gmail.com")
                .execute();
        response.path("movieBookings").entityList(MovieBooking.class).hasSize(0);
    }

    @Test
    void createMovieBooking() {
        GraphQlTester.Response response = this.graphQlTester.documentName("createMovieBooking").execute();
        response.path("createMovieBooking").entity(MovieBooking.class)
                .satisfies(movieBooking -> assertThat(movieBooking.getEmail()).isEqualTo("email@albathanext.com"));
    }
}