package com.bridgelabz;

// uc10: generic quantity class with unit interface

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    // Initializes a quantity with validation
    public Quantity(double value, U unit) {

        if (!Double.isFinite(value) || unit == null) {
            throw new IllegalArgumentException("Invalid quantity");
        }

        this.value = value;
        this.unit = unit;
    }

    // Returns the quantity value
    public double getValue() {
        return value;
    }

    // Returns the measurement unit
    public U getUnit() {
        return unit;
    }

    // Converts the current quantity into its base unit
    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    // Converts the quantity into the specified target unit
    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null
                || unit.getClass() != targetUnit.getClass()) {
            throw new IllegalArgumentException("Incompatible units");
        }

        double baseValue = convertToBaseUnit();

        double result = targetUnit.convertFromBaseUnit(baseValue);

        // Round the converted result to two decimal places
        result = Math.round(result * 100.0) / 100.0;

        return new Quantity<>(result, targetUnit);
    }

    // Adds another quantity and returns the result in the first operand's unit
    public Quantity<U> add(Quantity<U> other) {
        return add(other, this.unit);
    }

    // Adds another quantity and returns the result in the specified target unit
    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        if (other == null || targetUnit == null
                || this.unit.getClass() != other.unit.getClass()
                || this.unit.getClass() != targetUnit.getClass()) {
            throw new IllegalArgumentException("Incompatible quantities");
        }

        double sum = this.convertToBaseUnit()
                + other.convertToBaseUnit();

        if (!Double.isFinite(sum)) {
            throw new IllegalArgumentException("Addition result is out of range");
        }

        double result = targetUnit.convertFromBaseUnit(sum);

        return new Quantity<>(result, targetUnit);
    }

    // Compares two quantities after converting them into their base units
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Quantity<?> other = (Quantity<?>) obj;

        if (this.unit.getClass() != other.unit.getClass()) {
            return false;
        }

        return Double.compare(
                this.convertToBaseUnit(),
                other.convertToBaseUnit()
        ) == 0;
    }

    // Generates a hash code based on the base unit value
    @Override
    public int hashCode() {
        return Double.hashCode(convertToBaseUnit());
    }

    // Returns a readable representation of the quantity
    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.getUnitName() + ")";
    }
}
