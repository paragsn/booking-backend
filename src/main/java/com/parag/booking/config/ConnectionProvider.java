package com.parag.booking.config;

import javax.sql.DataSource;

import snaq.db.DBPoolDataSource;

public enum ConnectionProvider {
    INSTANCE;

    private DataSource dataSource;

    private ConnectionProvider() {
    }

    public DataSource getDataSource(String name, String driverClass, String uRL, String user, String password) {
        if (dataSource == null) {
            DBPoolDataSource ds = new DBPoolDataSource();
            ds.setName(name);
            ds.setDriverClassName(driverClass);
            ds.setUrl(uRL);
            ds.setUser(user);
            ds.setPassword(password);

            this.dataSource = ds;
        }
        return dataSource;
    }
}
