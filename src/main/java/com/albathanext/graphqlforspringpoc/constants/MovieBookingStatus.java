package com.albathanext.graphqlforspringpoc.constants;


import com.albathanext.graphqlforspringpoc.model.MovieBooking;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MovieBookingStatus {
    BOOKED("BOOKED"), CANCELLED("CANCELLED");
    @Getter
    private String status;

    @Override
    public String toString() {
        return this.getStatus();
    }
}
