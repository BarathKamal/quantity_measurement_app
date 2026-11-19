package com.bridgelabz;

public class QuantityMeasurementApp {

    // uc3: generic quantity class for dry principle
    // Compares two Length measurements
    public static void demonstrateLengthEquality(
            Length length1, Length length2) {

        System.out.println("Are both lengths equal? "
                + length1.equals(length2));
    }


    // Main method
    public static void main(String[] args) {

        // Feet and Inches comparison
        demonstrateLengthEquality(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES)
        );

        // Yards and Feet comparison
        demonstrateLengthEquality(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET)
        );

        // Yards and Inches comparison
        demonstrateLengthEquality(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(36.0, Length.LengthUnit.INCHES)
        );

        // Centimeters and Inches comparison
        demonstrateLengthEquality(
                new Length(1.0, Length.LengthUnit.CENTIMETERS),
                new Length(0.393701, Length.LengthUnit.INCHES)
        );
    }

}