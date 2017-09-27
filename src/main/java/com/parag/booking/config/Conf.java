package com.parag.booking.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Conf {

    public DBProperties getConfig(String configFilePath) throws IOException {

        final Properties defaultProps = new Properties();
        try (final InputStreamReader reader = new InputStreamReader(new FileInputStream(configFilePath), "UTF-8")) {
            defaultProps.load(reader);
        }

        String name = defaultProps.getProperty(Configuration.NAME.getValue());
        String driverClass = defaultProps.getProperty(Configuration.DRIVER_CLASS.getValue());
        String uRL = defaultProps.getProperty(Configuration.URL.getValue());
        String user = defaultProps.getProperty(Configuration.USER.getValue());
        String password = defaultProps.getProperty(Configuration.PASSWORD.getValue());

        DBProperties dbDetails = new DBProperties(name, driverClass, uRL, user, password);

        return dbDetails;
    }


}
