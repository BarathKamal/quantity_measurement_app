
package com.bridgelabz;

// uc3: generic quantity class for dry principle

public class Length {

    // uc4: extended unit support
    // Enum representing length units and their conversion factors to inches
    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        // Initializes the conversion factor for each unit
        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        // Returns the conversion factor
        public double getConversionFactor() {
            return conversionFactor;
        }
    }


    private final double value;
    private final LengthUnit unit;

    // Initializes the length value and its unit
    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    // Converts the measurement into the base unit (inches)
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    // Compares two Length objects after converting them into inches
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Length other = (Length) obj;

        return Double.compare(
                this.convertToBaseUnit(),
                other.convertToBaseUnit()
        ) == 0;
    }

    // Generates a hash code based on the converted measurement
    @Override
    public int hashCode() {
        return Double.hashCode(convertToBaseUnit());
    }

    // uc5: unit-to-unit conversion
    // Converts a value from source unit to target unit
    public static double convert(double value, LengthUnit sourceUnit,
                                 LengthUnit targetUnit) {

        if (!Double.isFinite(value) || sourceUnit == null
                || targetUnit == null) {
            throw new IllegalArgumentException("Invalid conversion input");
        }

        double baseValue = value * sourceUnit.getConversionFactor();
        double result = baseValue / targetUnit.getConversionFactor();

        if (!Double.isFinite(result)) {
            throw new IllegalArgumentException("Conversion result is out of range");
        }

        return result;
    }

    // uc5: unit-to-unit conversion
    // Converts the current Length object into a new target unit object
    public Length convertTo(LengthUnit targetUnit) {

        double convertedValue = convert(this.value, this.unit, targetUnit);

        return new Length(convertedValue, targetUnit);
    }

    // uc5: unit-to-unit conversion
    // Returns a readable representation of the length measurement
    @Override
    public String toString() {
        return value + " " + unit;
    }


    // uc6: addition of two length units
    // uc7: addition with target unit specification
    // Adds another measurement and returns the result in the first operand's unit
    public Length add(Length other) {
        return addAndConvert(other, this.unit);
    }

    // Adds another measurement and returns the result in the specified target unit
    public Length add(Length other, LengthUnit targetUnit) {
        return addAndConvert(other, targetUnit);
    }

    // Performs addition and converts the result into the requested unit
    private Length addAndConvert(Length other, LengthUnit targetUnit) {

        if (other == null || this.unit == null || other.unit == null
                || targetUnit == null
                || !Double.isFinite(this.value)
                || !Double.isFinite(other.value)) {
            throw new IllegalArgumentException("Invalid length measurements");
        }

        // Convert both measurements into the base unit
        double firstValue = this.convertToBaseUnit();
        double secondValue = other.convertToBaseUnit();

        // Add both measurements
        double sum = firstValue + secondValue;

        if (!Double.isFinite(sum)) {
            throw new IllegalArgumentException("Addition result is out of range");
        }

        // Convert the sum into the specified target unit
        double result = sum / targetUnit.getConversionFactor();

        if (!Double.isFinite(result)) {
            throw new IllegalArgumentException("Conversion result is out of range");
        }

        return new Length(result, targetUnit);
    }

}

