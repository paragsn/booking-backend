package com.parag.booking.manager;

import java.util.List;

import com.parag.booking.model.CustomerDetails;
import com.parag.booking.model.Driver;
import com.parag.booking.utility.Utility;

public class ProcessManager {

    /**
     * Finds out Driver which has minimum distance from the Customer
     * 
     * @param customerDetails
     * @param drivers
     * @return
     */
    public Driver findBestDriver(CustomerDetails customerDetails, List<Driver> drivers) {

        double min = -1.0;
        Driver bestDriver = null;
        boolean firstIteration = true;

        for (Driver driver : drivers) {
            double dist = Utility.distance(customerDetails.getGeo().getLattitude(), customerDetails.getGeo().getLongitude(),
                    driver.getGeo().getLattitude(), driver.getGeo().getLongitude());
            if (firstIteration) {
                min = dist;
                bestDriver = driver;
                firstIteration = false;
            }
            if (dist < min) {
                min = dist;
                bestDriver = driver;
            }
        }

        return bestDriver;
    }
}
