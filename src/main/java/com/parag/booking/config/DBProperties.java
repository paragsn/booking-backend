package com.parag.booking.config;

public class DBProperties {

    private String name;
    private String driverClass;
    private String uRL;
    private String user;
    private String password;

    public DBProperties(String name, String driverClass, String uRL, String user, String password) {
        this.name = name;
        this.driverClass = driverClass;
        this.uRL = uRL;
        this.user = user;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public String getuRL() {
        return uRL;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "DBProperties [name=" + name + ", driverClass=" + driverClass + ", uRL=" + uRL + ", user=" + user + ", password=" + password
                + "]";
    }
    
}
