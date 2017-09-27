package com.parag.booking.model;

import java.io.Serializable;

public class Driver implements Serializable {
    
    private static final long serialVersionUID = -1812731264381074988L;

    private Integer id;
    private String name;
    private String status;
    private Geo geo;

    public Driver(Integer id, String name, String status, Geo geo) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.geo = geo;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Geo getGeo() {
        return geo;
    }

    @Override
    public String toString() {
        return "Driver [id=" + id + ", name=" + name + ", status=" + status + ", geo=" + geo + "]";
    }
}
