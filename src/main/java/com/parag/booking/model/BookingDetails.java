package com.parag.booking.model;

import java.io.Serializable;
import java.util.List;

public class BookingDetails implements Serializable {

    private static final long serialVersionUID = 1924822927264498865L;

    private List<CurrentBooking> currentBooking;

    public BookingDetails(List<CurrentBooking> currentBooking) {
        this.currentBooking = currentBooking;
    }

    public List<CurrentBooking> getBookingDetails() {
        return currentBooking;
    }

    @Override
    public String toString() {
        return "BookingDetails [bookingDetails=" + currentBooking + "]";
    }
}