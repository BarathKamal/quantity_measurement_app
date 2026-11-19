package com.bridgelabz;

// uc9: weight measurement equality, conversion, and addition

public enum WeightUnit {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    // Initializes the conversion factor relative to kilograms
    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Returns the conversion factor
    public double getConversionFactor() {
        return conversionFactor;
    }

    // Converts the current unit value into kilograms
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    // Converts kilograms into the current unit
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }
}
