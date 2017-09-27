package com.parag.booking.run;

import java.io.IOException;

import javax.sql.DataSource;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.parag.booking.BookingService;
import com.parag.booking.config.Conf;
import com.parag.booking.config.ConnectionProvider;
import com.parag.booking.config.DBProperties;
import com.parag.booking.dao.BookingDao;
import com.parag.booking.manager.DataManager;
import com.parag.booking.manager.ProcessManager;

@ApplicationPath("/app")
public class Startup extends ResourceConfig {

    public Startup() {
//        String confFile = "filePath/config.properties";
        String confFile = "F:\\NewParag\\eclipse-workspace\\Booking\\src\\test\\resources\\properties.conf";
        Conf config = new Conf();
        DBProperties dBProperties = null;
        try {
            dBProperties = config.getConfig(confFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DataSource dataSource = ConnectionProvider.INSTANCE.getDataSource(dBProperties.getName(), dBProperties.getDriverClass(),
                dBProperties.getuRL(), dBProperties.getUser(), dBProperties.getPassword());

        DataManager dataManager = new DataManager(dataSource, new BookingDao(), new ProcessManager());
        BookingService bookingService = new BookingService(dataManager);
        register(bookingService);
    }
}
