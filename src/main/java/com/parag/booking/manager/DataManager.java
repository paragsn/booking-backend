package com.parag.booking.manager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.parag.booking.dao.BookingDao;
import com.parag.booking.exception.DataDeleteException;
import com.parag.booking.exception.DataFetchException;
import com.parag.booking.exception.DataUpdateException;
import com.parag.booking.model.CurrentBooking;
import com.parag.booking.model.CustomerDetails;
import com.parag.booking.model.Driver;

/**
 * @author parag
 *
 */
public class DataManager {

    private DataSource dataSource;
    private BookingDao bookingDao;
    private ProcessManager processManager;

    public DataManager(DataSource dataSource, BookingDao bookingDao, ProcessManager processManager) {
        this.dataSource = dataSource;
        this.bookingDao = bookingDao;
        this.processManager = processManager;
    }
    
    /**
     * Gets the best driver suitable for passed customer
     * 
     * @param customerDetails
     * @return
     */
    public Driver getDriver(CustomerDetails customerDetails) {
        Driver driver = null;
        Connection connection = null;
        //Maitaining Transaction here
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);

            List<Driver> drivers = bookingDao.getAllDrivers(dataSource.getConnection());

            driver = processManager.findBestDriver(customerDetails, drivers);
            bookingDao.updateDriverStatus(dataSource.getConnection(), driver);
            bookingDao.updateCurrentDetails(dataSource.getConnection(), customerDetails, driver);

        } catch (SQLException | DataFetchException | DataUpdateException | DataDeleteException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    // Nothing can be done here :)
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException e1) {
                    // Nothing can be done here :)
                }
                try {
                    connection.close();
                } catch (SQLException e) {
                    // Nothing can be done here :)
                }
            }
        }
        return driver;
    }

    /**
     * Current details
     * 
     * @return
     */
    public List<CurrentBooking> getCurrentDetails() {
        List<CurrentBooking> bookingDetails = null;
        try {
            bookingDetails = bookingDao.getCurrentStatus(dataSource.getConnection());
        } catch (DataFetchException | SQLException e) {
            return bookingDetails;
        }
        return bookingDetails;
    }

}
