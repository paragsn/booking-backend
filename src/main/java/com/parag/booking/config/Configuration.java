package com.parag.booking.config;

public enum Configuration {

    NAME("name"), //
    DRIVER_CLASS("driverClass"), //
    URL("uRL"), //
    USER("user"), //
    PASSWORD("password");

    private String value;

    private Configuration(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
