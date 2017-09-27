package com.parag.booking.model;

import java.io.Serializable;

public class CurrentBooking implements Serializable {

    private static final long serialVersionUID = 5196825332612532618L;
    
    private String driver;
    private String customer;
    private String status;
    
    public CurrentBooking(String driver, String customer, String status) {
        this.driver = driver;
        this.customer = customer;
        this.status = status;
    }

    public String getDriver() {
        return driver;
    }

    public String getCustomer() {
        return customer;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "CurrentBooking [driver=" + driver + ", customer=" + customer + ", status=" + status + "]";
    }
}
