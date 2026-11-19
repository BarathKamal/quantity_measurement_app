package com.bridgelabz;

// uc9: weight measurement equality, conversion, and addition

public class QuantityWeight {

    private final double value;
    private final WeightUnit unit;

    private static final double EPSILON = 1e-5;

    // Initializes a weight measurement with validation
    public QuantityWeight(double value, WeightUnit unit) {

        if (!Double.isFinite(value) || unit == null) {
            throw new IllegalArgumentException("Invalid weight measurement");
        }

        this.value = value;
        this.unit = unit;
    }

    // Converts the measurement into the base unit (kilograms)
    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    // Compares two weight measurements after base unit conversion
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        QuantityWeight other = (QuantityWeight) obj;

        return Math.abs(this.convertToBaseUnit()
                - other.convertToBaseUnit()) <= EPSILON;
    }

    // Generates a hash code based on the normalized weight
    @Override
    public int hashCode() {
        return Math.round((float) (convertToBaseUnit() * 100000));
    }

    // Converts the current weight into the specified target unit
    public QuantityWeight convertTo(WeightUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = convertToBaseUnit();
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);

        return new QuantityWeight(convertedValue, targetUnit);
    }

    // Adds another weight and returns the result in the first operand's unit
    public QuantityWeight add(QuantityWeight other) {
        return addAndConvert(other, this.unit);
    }

    // Adds another weight and returns the result in the specified target unit
    public QuantityWeight add(QuantityWeight other, WeightUnit targetUnit) {
        return addAndConvert(other, targetUnit);
    }

    // Performs weight addition using kilograms as the base unit
    private QuantityWeight addAndConvert(
            QuantityWeight other, WeightUnit targetUnit) {

        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid weight measurements");
        }

        double sum = this.convertToBaseUnit()
                + other.convertToBaseUnit();

        if (!Double.isFinite(sum)) {
            throw new IllegalArgumentException("Addition result is out of range");
        }

        double result = targetUnit.convertFromBaseUnit(sum);

        return new QuantityWeight(result, targetUnit);
    }

    // Returns a readable representation of the weight measurement
    @Override
    public String toString() {
        return value + " " + unit;
    }
}
