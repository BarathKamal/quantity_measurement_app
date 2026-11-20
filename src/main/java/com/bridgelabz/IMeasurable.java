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
}

