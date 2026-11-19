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
            Length.LengthUnit sourceUnit,
            Length.LengthUnit targetUnit) {

        double result = Length.convert(value, sourceUnit, targetUnit);

        System.out.println(value + " " + sourceUnit + " = "
                + result + " " + targetUnit);
    }

    // uc5: unit-to-unit conversion
    // Converts an existing Length object into the target unit
    public static void demonstrateLengthConversion(
            Length length, Length.LengthUnit targetUnit) {

        Length convertedLength = length.convertTo(targetUnit);

        System.out.println("Converted measurement: " + convertedLength);
    }

    // Main method
    public static void main(String[] args) {

        // Static conversion examples
        demonstrateLengthConversion(
                1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);

        demonstrateLengthConversion(
                3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET);

        demonstrateLengthConversion(
                36.0, Length.LengthUnit.INCHES, Length.LengthUnit.YARDS);

        demonstrateLengthConversion(
                1.0, Length.LengthUnit.CENTIMETERS, Length.LengthUnit.INCHES);

        // Instance conversion example
        Length length = new Length(5.0, Length.LengthUnit.FEET);

        demonstrateLengthConversion(
                length, Length.LengthUnit.INCHES);
    }

}