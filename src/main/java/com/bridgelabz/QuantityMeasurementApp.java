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

    // uc6: addition of two length units
    // Demonstrates addition of two Length measurements
    public static Length demonstrateLengthAddition(
            Length length1, Length length2) {

        Length result = length1.add(length2);

        System.out.println("Addition result: " + result);

        return result;
    }

    // Main method
    public static void main(String[] args) {

        // Feet + Feet
        demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(2.0, Length.LengthUnit.FEET)
        );

        // Feet + Inches
        demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES)
        );

        // Inches + Feet
        demonstrateLengthAddition(
                new Length(12.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.FEET)
        );

        // Yards + Feet
        demonstrateLengthAddition(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET)
        );

        // Centimeters + Inches
        demonstrateLengthAddition(
                new Length(2.54, Length.LengthUnit.CENTIMETERS),
                new Length(1.0, Length.LengthUnit.INCHES)
        );

        // Feet + Zero
        demonstrateLengthAddition(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(0.0, Length.LengthUnit.INCHES)
        );

        // Feet + Negative Feet
        demonstrateLengthAddition(
                new Length(5.0, Length.LengthUnit.FEET),
                new Length(-2.0, Length.LengthUnit.FEET)
        );
    }
}