package com.parag.booking.exception;

/**
 * The purpose of this class is to create an exception which is thrown when there is any issue with data Fetch
 */
public class DataFetchException extends Exception {

    private static final long serialVersionUID = -7076374176441806500L;

    /**
     * Constructor. Initializes this exception as a wrapper for another exception, with an explanatory message.
     *
     * @param msg the explanatory message
     * @param wrappedException the exception being wrapped
     */
    public DataFetchException(String msg, Throwable wrappedException) {
        super(msg, wrappedException);
    }

    /**
     * Constructor. Initializes this exception as a wrapper for another exception.
     *
     * @param wrappedException the exception being wrapped
     */
    public DataFetchException(Throwable wrappedException) {
        super(wrappedException);
    }

    /**
     * Initializes this exception with message
     *
     * @param msg
     */
    public DataFetchException(String msg) {
        super(msg);
    }
}
