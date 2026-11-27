package com.bridgelabz;

import java.util.function.DoubleBinaryOperator;

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

    // uc13: centralized arithmetic logic to enforce DRY
    // Defines arithmetic operations using lambda expressions
    private enum ArithmeticOperation {

        ADD((a, b) -> a + b),

        SUBTRACT((a, b) -> a - b),

        DIVIDE((a, b) -> {
            if (b == 0.0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a / b;
        });

        private final DoubleBinaryOperator operation;

        // Initializes the arithmetic operation
        ArithmeticOperation(DoubleBinaryOperator operation) {
            this.operation = operation;
        }

        // Executes the selected arithmetic operation
        public double compute(double a, double b) {
            return operation.applyAsDouble(a, b);
        }
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
        return add(other, unit);
    }


    // uc13: centralized arithmetic logic to enforce DRY
    // Adds another quantity and returns the result in the specified unit
    public Quantity<U> add(Quantity<U> other, U targetUnit) {

        validateArithmeticOperands(other, targetUnit, true);

        double result = performBaseArithmetic(
                other, ArithmeticOperation.ADD);

        double convertedResult =
                targetUnit.convertFromBaseUnit(result);

        return new Quantity<>(
                roundToTwoDecimals(convertedResult), targetUnit);
    }

    // uc12: subtraction and division operations
    // Subtracts another quantity and returns the result in the current unit
    public Quantity<U> subtract(Quantity<U> other) {
        return subtract(other, unit);
    }

    // uc13: centralized arithmetic logic to enforce DRY
    // Subtracts another quantity and returns the result in the specified unit
    public Quantity<U> subtract(Quantity<U> other, U targetUnit) {

        validateArithmeticOperands(other, targetUnit, true);

        double result = performBaseArithmetic(
                other, ArithmeticOperation.SUBTRACT);

        double convertedResult =
                targetUnit.convertFromBaseUnit(result);

        return new Quantity<>(
                roundToTwoDecimals(convertedResult), targetUnit);
    }

    // uc13: centralized arithmetic logic to enforce DRY
    // Divides another quantity and returns a dimensionless ratio
    public double divide(Quantity<U> other) {

        validateArithmeticOperands(other, null, false);

        return performBaseArithmetic(
                other, ArithmeticOperation.DIVIDE);
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

    // uc13: centralized arithmetic logic to enforce DRY
    // Validates operands and target unit for arithmetic operations
    private void validateArithmeticOperands(
            Quantity<U> other,
            U targetUnit,
            boolean targetUnitRequired) {

        if (other == null) {
            throw new IllegalArgumentException(
                    "Quantity operand cannot be null");
        }

        if (unit == null || other.unit == null
                || unit.getClass() != other.unit.getClass()) {
            throw new IllegalArgumentException(
                    "Incompatible measurement categories");
        }

        if (!Double.isFinite(value)
                || !Double.isFinite(other.value)) {
            throw new IllegalArgumentException(
                    "Quantity values must be finite");
        }

        if (targetUnitRequired) {
            if (targetUnit == null
                    || unit.getClass() != targetUnit.getClass()) {
                throw new IllegalArgumentException(
                        "Invalid target unit");
            }
        }
    }

    // Converts operands to base units and performs the requested operation
    private double performBaseArithmetic(
            Quantity<U> other,
            ArithmeticOperation operation) {

        double firstBase =
                unit.convertToBaseUnit(value);

        double secondBase =
                other.unit.convertToBaseUnit(other.value);

        double result = operation.compute(firstBase, secondBase);

        if (!Double.isFinite(result)) {
            throw new IllegalArgumentException(
                    "Arithmetic result is out of range");
        }

        return result;
    }

    // Rounds arithmetic results to two decimal places
    private double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
