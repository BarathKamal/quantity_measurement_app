package com.bridgelabz;

public class QuantityMeasurementApp {

    // uc3: generic quantity class for dry principle
    // Compares two Length measurements
    public static void demonstrateLengthEquality(
            Length length1, Length length2) {

        System.out.println("Are both lengths equal? "
                + length1.equals(length2));
    }

    // uc5: unit-to-unit conversion
    // Converts a raw value between two units
    public static void demonstrateLengthConversion(
            double value,
            LengthUnit sourceUnit,
            LengthUnit targetUnit) {

        double result = Length.convert(value, sourceUnit, targetUnit);

        System.out.println(value + " " + sourceUnit + " = "
                + result + " " + targetUnit);
    }

    // uc5: unit-to-unit conversion
    // Converts an existing Length object into the target unit
    public static void demonstrateLengthConversion(
            Length length, LengthUnit targetUnit) {

        Length convertedLength = length.convertTo(targetUnit);

        System.out.println("Converted measurement: " + convertedLength);
    }

    // uc6: addition of two length units
    // Demonstrates addition of two Length measurements
    public static Length demonstrateLengthAddition(
            Length length1, Length length2) {

        Length result = length1.add(length2);

        System.out.println("Addition result: " + result);

        return result;
    }

    // uc7: addition with target unit specification
    // Demonstrates addition with an explicitly specified result unit
    public static Length demonstrateLengthAddition(
            Length length1, Length length2,
            LengthUnit targetUnit) {

        Length result = length1.add(length2, targetUnit);

        System.out.println("Addition result: " + result);

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);

        // Result in Feet
        demonstrateLengthAddition(
                length1, length2, LengthUnit.FEET);

        // Result in Inches
        demonstrateLengthAddition(
                length1, length2, LengthUnit.INCHES);

        // Result in Yards
        demonstrateLengthAddition(
                length1, length2, LengthUnit.YARDS);

        // Result in Centimeters
        demonstrateLengthAddition(
                length1, length2, LengthUnit.CENTIMETERS);

        // Different operand units and target unit
        demonstrateLengthAddition(
                new Length(1.0, LengthUnit.YARDS),
                new Length(3.0, LengthUnit.FEET),
                LengthUnit.INCHES);
    }

}