
package com.bridgelabz;

import java.util.function.Function;

// uc14: temperature measurement with selective arithmetic support and IMeasurable refactoring

public enum TemperatureUnit implements IMeasurable {

    CELSIUS(value -> value),
    FAHRENHEIT(value -> (value - 32) * 5 / 9),
    KELVIN(value -> value - 273.15);

    private final Function<Double, Double> conversionValue;

    // Indicates that temperature does not support arithmetic operations
    private final SupportsArithmetic supportsArithmetic = () -> false;

    // Initializes the temperature conversion function
    TemperatureUnit(Function<Double, Double> conversionValue) {
        this.conversionValue = conversionValue;
    }

    // Returns the temperature unit name
    @Override
    public String getUnitName() {
        return name();
    }

    // Returns the conversion factor for the temperature base unit
    @Override
    public double getConversionFactor() {
        return 1.0;
    }

    // Converts the temperature into Celsius
    @Override
    public double convertToBaseUnit(double value) {
        return conversionValue.apply(value);
    }

    // Converts Celsius into the current temperature unit
    @Override
    public double convertFromBaseUnit(double baseValue) {

        double result;

        switch (this) {
            case CELSIUS:
                result = baseValue;
                break;

            case FAHRENHEIT:
                result = (baseValue * 9 / 5) + 32;
                break;

            case KELVIN:
                result = baseValue + 273.15;
                break;

            default:
                throw new IllegalArgumentException("Unsupported temperature unit");
        }

        return Math.round(result * 100.0) / 100.0;
    }

    // Converts the current temperature into the specified target unit
    public double convertTo(double value, TemperatureUnit targetUnit) {

        if (targetUnit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid temperature conversion");
        }

        double baseValue = convertToBaseUnit(value);

        return targetUnit.convertFromBaseUnit(baseValue);
    }

    // Indicates that temperature does not support arithmetic
    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    // Rejects unsupported temperature arithmetic operations
    @Override
    public void validateOperationSupport(String operation) {

        if (!supportsArithmetic()) {
            String message = "Temperature does not support "
                    + operation.toLowerCase() + " operation";

            throw new UnsupportedOperationException(message);
        }
    }

    // uc15: n-tier architecture refactoring
    // Retrieves a temperature unit using its name
    @Override
    public IMeasurable getUnitInstance(String unitName) {
        return TemperatureUnit.valueOf(unitName.toUpperCase());
    }

}
