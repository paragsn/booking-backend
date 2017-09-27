package com.parag.booking.utility;

import com.parag.booking.model.CurrentBooking;

public class Utility {
    
    public static CurrentBooking getDummyBookingDetails() {
        CurrentBooking bookingDetails = new CurrentBooking("D1", "C1", "Available");
        return bookingDetails;
    }

    /**
     * Haversine method
     */
    public static double distance(double lattitude1, double lattitude2, double longitude1, double longitude2) {

        final int R = 6371; // Radius of the earth

        double lattitudeD = Math.toRadians(lattitude2 - lattitude1);
        double longitudeD = Math.toRadians(longitude2 - longitude1);
        
        double x = Math.sin(lattitudeD / 2) * Math.sin(lattitudeD / 2) + Math.cos(Math.toRadians(lattitude1))
        * Math.cos(Math.toRadians(lattitude2)) * Math.sin(longitudeD / 2) * Math.sin(longitudeD / 2);
        
        double y = 2 * Math.atan2(Math.sqrt(x), Math.sqrt(1 - x));
        double distance = R * y * 1000; // convert to meters

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }

}
