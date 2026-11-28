package com.bridgelabz;

// uc10: generic quantity class with unit interface
public enum WeightUnit implements IMeasurable {

    MILLIGRAM(0.001),
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592),
    TONNE(1000000.0);

    private final double conversionFactor;

    // Initializes the conversion factor relative to grams
    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Returns the conversion factor
    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    // Converts the value into grams
    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    // Converts grams into the current unit
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
    // Retrieves a weight unit using its name
    @Override
    public IMeasurable getUnitInstance(String unitName) {
        return WeightUnit.valueOf(unitName.toUpperCase());
    }

}
