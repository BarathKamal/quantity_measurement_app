package com.bridgelabz;

// uc11: volume measurement equality, conversion, and addition

public enum VolumeUnit implements IMeasurable {

    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);

    private final double conversionFactor;

    // Initializes the conversion factor relative to litres
    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    // Returns the conversion factor
    @Override
    public double getConversionFactor() {
        return conversionFactor;
    }

    // Converts the volume into litres
    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    // Converts litres into the current unit
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
    // Retrieves a volume unit using its name
    @Override
    public IMeasurable getUnitInstance(String unitName) {
        return VolumeUnit.valueOf(unitName.toUpperCase());
    }

}

