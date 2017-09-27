package com.parag.booking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.parag.booking.exception.DataDeleteException;
import com.parag.booking.exception.DataFetchException;
import com.parag.booking.exception.DataUpdateException;
import com.parag.booking.model.CurrentBooking;
import com.parag.booking.model.CustomerDetails;
import com.parag.booking.model.Driver;
import com.parag.booking.model.Geo;

/**
 * Class containing all the Dao methods
 * 
 * @author parag
 *
 */
public class BookingDao {

    /**
     * Gets all drivers who are Available
     * 
     * @param connection
     * @return
     * @throws DataFetchException
     */
    public List<Driver> getAllDrivers(Connection connection) throws DataFetchException {
        List<Driver> drivers = new ArrayList<>();
        String query = "SELECT d.id, d.name, s.code, l.lattitude, l.longitude " + "FROM driver d, status s, driver_location l "
                + "WHERE d.status = '1' and l.driver = d.id;";
        try (final PreparedStatement pstmt = connection.prepareStatement(query)) {

            try (final ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    drivers.add(new Driver(resultSet.getInt(0), resultSet.getString(1), resultSet.getString(2),
                            new Geo(resultSet.getDouble(3), resultSet.getDouble(4))));
                }
            }
        } catch (SQLException sqle) {
            throw new DataFetchException("Exception Occured while fetching data", sqle);
        }
        return drivers;
    }

    /**
     * Change the status of driver to Busy
     * 
     * @param connection
     * @param driver
     * @throws DataUpdateException
     */
    public void updateDriverStatus(Connection connection, Driver driver) throws DataUpdateException {
        String query = "UPDATE driver SET status = 2 WHERE id = ? ;";
        try (final PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(0, driver.getId());
            pstmt.execute();
        } catch (SQLException sqle) {
            throw new DataUpdateException("Exception Occured while Updating data", sqle);
        }
    }

    /**
     * Update Current Booking Details table
     * 
     * @param connection
     * @param customerDetails
     * @param driver
     * @throws DataUpdateException
     * @throws DataDeleteException
     */
    public void updateCurrentDetails(Connection connection, CustomerDetails customerDetails, Driver driver)
            throws DataUpdateException, DataDeleteException {
        deleteEntry(connection, driver);
        String query = "INSERT INTO current_details ( driver_id, customer_id ) VALUES ( ? ,(SELECT id from customer where name = ? ));";
        try (final PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(0, driver.getId());
            pstmt.setString(1, customerDetails.getName());

            pstmt.execute();
        } catch (SQLException sqle) {
            throw new DataUpdateException("Exception Occured while Updating data", sqle);
        }
    }

    /**
     * Deletes entry from Current details table
     * 
     * @param connection
     * @param driver
     * @throws DataDeleteException
     */
    private void deleteEntry(Connection connection, Driver driver) throws DataDeleteException {
        String query = "DELETE FROM current_details where driver_id = ? ;";
        try (final PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(0, driver.getId());
            
            pstmt.execute();
        } catch (SQLException sqle) {
            throw new DataDeleteException("Exception Occured while Deleting data", sqle);
        }
    }

    /**
     * Fetches the  current Status of all drivers with Customers linked, if any
     * 
     * @param connection
     * @return
     * @throws DataFetchException
     */
    public List<CurrentBooking> getCurrentStatus(Connection connection) throws DataFetchException {
        List<CurrentBooking> bookingDetails = new ArrayList<>();
        String query = "SELECT driver.name, customer.name, status.code " + "FROM current_details "
                + "JOIN customer ON current_details.customer_id = customer.id " + "RIGHT JOIN driver ON current_details.driver_id = driver.id "
                + "JOIN status ON driver.status = status.id;";
        try (final PreparedStatement pstmt = connection.prepareStatement(query)) {

            try (final ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    bookingDetails.add(new CurrentBooking(resultSet.getString(0), resultSet.getString(1), resultSet.getString(2)));
                }
            }
        } catch (SQLException sqle) {
            throw new DataFetchException("Exception Occured while fetching data", sqle);
        }
        return bookingDetails;
    }

}
