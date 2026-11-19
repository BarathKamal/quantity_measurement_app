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

        Length length1 = new Length(1.0, Length.LengthUnit.FEET);
        Length length2 = new Length(12.0, Length.LengthUnit.INCHES);

        demonstrateLengthEquality(length1, length2);
    }
}