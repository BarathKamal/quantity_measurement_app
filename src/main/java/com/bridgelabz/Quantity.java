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

    // uc12: subtraction and division operations
    // Subtracts another quantity and returns the result in the current unit
    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, this.unit);
    }

    // Subtracts another quantity and returns the result in the specified target unit
    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        if (other == null || targetUnit == null
                || this.unit.getClass() != other.unit.getClass()
                || this.unit.getClass() != targetUnit.getClass()) {
            throw new IllegalArgumentException("Incompatible quantities");
        }

        if (!Double.isFinite(this.value)
                || !Double.isFinite(other.value)) {
            throw new IllegalArgumentException("Invalid quantity values");
        }

        // Convert both quantities into the base unit
        double firstValue = this.convertToBaseUnit();
        double secondValue = other.convertToBaseUnit();

        // Subtract the converted values
        double difference = firstValue - secondValue;

        if (!Double.isFinite(difference)) {
            throw new IllegalArgumentException("Subtraction result is out of range");
        }

        // Convert the difference into the target unit
        double result = targetUnit.convertFromBaseUnit(difference);

        // Round the result to two decimal places
        result = Math.round(result * 100.0) / 100.0;

        return new Quantity<>(result, targetUnit);
    }


    // uc12: subtraction and division operations
    // Divides another quantity and returns a dimensionless ratio
    public double divide(Quantity<U> other) {

        if (other == null
                || this.unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException("Incompatible quantities");
        }

        if (!Double.isFinite(this.value)
                || !Double.isFinite(other.value)) {
            throw new IllegalArgumentException("Invalid quantity values");
        }

        // Convert both quantities into the base unit
        double firstValue = this.convertToBaseUnit();
        double secondValue = other.convertToBaseUnit();

        // Prevent division by zero
        if (secondValue == 0.0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }

        // Return the dimensionless ratio
        return firstValue / secondValue;
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

        // uc11: volume measurement equality, conversion, and addition
        return Math.abs(this.convertToBaseUnit()
                - other.convertToBaseUnit()) <= 1e-5;
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
