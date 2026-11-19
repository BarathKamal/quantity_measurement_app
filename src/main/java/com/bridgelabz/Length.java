
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
}

