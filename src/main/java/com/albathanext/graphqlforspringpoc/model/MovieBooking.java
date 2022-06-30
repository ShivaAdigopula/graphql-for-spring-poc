package com.albathanext.graphqlforspringpoc.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieBooking {
    private Integer id;
    private String first_name;
    private String last_name;
    private String email;
    private Integer number_of_seats;
    private String date;
    private Movie movie;
    private String status;

}
