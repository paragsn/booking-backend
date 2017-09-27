package com.parag.booking.model;

import java.io.Serializable;

public class Geo implements Serializable {
    
    private static final long serialVersionUID = -6034575549124952365L;

    private double lattitude;
    private double longitude;

    public Geo(double lattitude, double longitude) {
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public double getLattitude() {
        return lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Geo [Lattitude=" + lattitude + ", Longitude=" + longitude + "]";
    }

}
