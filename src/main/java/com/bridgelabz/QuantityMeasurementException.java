
package com.bridgelabz;

// uc15: n-tier architecture refactoring

public class QuantityMeasurementException extends RuntimeException {

    // Initializes an exception with an error message
    public QuantityMeasurementException(String message) {
        super(message);
    }

    // Initializes an exception with a message and cause
    public QuantityMeasurementException(String message, Throwable cause) {
        super(message, cause);
    }
}
