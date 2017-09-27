package com.parag.booking.model;

import java.io.Serializable;

public class CustomerDetails implements Serializable {

    private static final long serialVersionUID = -2372587447456954428L;

    private String name;
    private Geo geo;

    public CustomerDetails(String name, Geo geo) {
        this.name = name;
        this.geo = geo;
    }

    public String getName() {
        return name;
    }

    public Geo getGeo() {
        return geo;
    }

    @Override
    public String toString() {
        return "CustomerDetails [name=" + name + ", geo=" + geo + "]";
    }

}
