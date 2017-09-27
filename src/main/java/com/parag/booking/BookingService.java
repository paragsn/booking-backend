package com.parag.booking;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.parag.booking.manager.DataManager;
import com.parag.booking.model.BookingDetails;
import com.parag.booking.model.CustomerDetails;

@Path("/booking")
public class BookingService {

    private DataManager dataManager;

    public BookingService(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/book/{customerDetails: .+}")
    public void bookCab(CustomerDetails customerDetails) {
        dataManager.getDriver(customerDetails);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/current_bookings")
    public Response getCurrentBookingDetails() {
        BookingDetails bookingDetails = new BookingDetails(dataManager.getCurrentDetails());
        return Response.ok(bookingDetails).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/hello")
    public Response sayHello() {
        return Response.ok("Hi Hello").build();
    }

}
