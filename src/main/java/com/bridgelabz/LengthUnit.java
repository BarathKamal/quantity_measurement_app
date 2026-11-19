package com.bridgelabz;

// uc8: refactoring unit enum to standalone class
public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double conversionFactor;

    // Initializes the conversion factor relative to feet
    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Returns the conversion factor
    public double getConversionFactor() {
        return conversionFactor;
    }

    // Converts a value in the current unit into feet
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    // Converts a value in feet into the current unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}

