package com.bridgelabz;

// uc10: generic quantity class with unit interface
public enum LengthUnit implements IMeasurable {

    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    // Initializes the conversion factor relative to inches
    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Returns the conversion factor
    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    // Converts the value into inches
    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    // Converts inches into the current unit
    @Override
    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor;
    }

    // Returns the unit name
    @Override
    public String getUnitName() {
        return name();
    }

    // uc15: n-tier architecture refactoring
    // Retrieves a length unit using its name
    @Override
    public IMeasurable getUnitInstance(String unitName) {
        return LengthUnit.valueOf(unitName.toUpperCase());
    }

}
