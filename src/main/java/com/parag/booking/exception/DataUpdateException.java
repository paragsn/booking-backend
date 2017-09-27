package com.parag.booking.exception;

/**
 * The purpose of this class is to create an exception which is thrown when there is any issue with data Fetch
 */
public class DataUpdateException extends Exception {

    private static final long serialVersionUID = -878730074555062379L;

    /**
     * Constructor. Initializes this exception as a wrapper for another exception, with an explanatory message.
     *
     * @param msg the explanatory message
     * @param wrappedException the exception being wrapped
     */
    public DataUpdateException(String msg, Throwable wrappedException) {
        super(msg, wrappedException);
    }

    /**
     * Constructor. Initializes this exception as a wrapper for another exception.
     *
     * @param wrappedException the exception being wrapped
     */
    public DataUpdateException(Throwable wrappedException) {
        super(wrappedException);
    }

    /**
     * Initializes this exception with message
     *
     * @param msg
     */
    public DataUpdateException(String msg) {
        super(msg);
    }
}
