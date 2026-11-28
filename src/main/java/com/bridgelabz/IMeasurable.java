package com.bridgelabz;

// uc10: generic quantity class with unit interface
public interface IMeasurable {

    // Returns the conversion factor relative to the base unit
    double getConversionFactor();

    // Converts the given value into the base unit
    double convertToBaseUnit(double value);

    // Converts a base unit value into the current unit
    double convertFromBaseUnit(double baseValue);

    // Returns the readable unit name
    String getUnitName();

    // uc14: temperature measurement with selective arithmetic support and IMeasurable refactoring
    // Allows measurable units to define arithmetic support
    SupportsArithmetic supportsArithmetic = () -> true;

    // Checks whether arithmetic operations are supported
    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    // Validates whether the requested arithmetic operation is supported
    default void validateOperationSupport(String operation) {
        // Existing measurement categories support arithmetic by default
    }

    // uc15: n-tier architecture refactoring
    // Returns the measurement category
    default String getMeasurementType() {
        return getClass().getSimpleName();
    }

    // Retrieves a unit instance using its name
    IMeasurable getUnitInstance(String unitName);


}

