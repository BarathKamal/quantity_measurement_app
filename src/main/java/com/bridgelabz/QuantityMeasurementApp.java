package com.bridgelabz;

public class QuantityMeasurementApp {

    // uc10: generic quantity class with unit interface
    // Demonstrates equality comparison between two quantities
    public static boolean demonstrateEquality(
            Quantity<?> quantity1, Quantity<?> quantity2) {

        return quantity1.equals(quantity2);
    }

    // Demonstrates conversion of a quantity into a target unit
    public static <U extends IMeasurable> Quantity<U>
    demonstrateConversion(Quantity<U> quantity, U targetUnit) {

        return quantity.convertTo(targetUnit);
    }

    // Demonstrates addition with the result in the first quantity's unit
    public static <U extends IMeasurable> Quantity<U>
    demonstrateAddition(Quantity<U> quantity1, Quantity<U> quantity2) {

        return quantity1.add(quantity2);
    }

    // Demonstrates addition with a specified target unit
    public static <U extends IMeasurable> Quantity<U>
    demonstrateAddition(
            Quantity<U> quantity1,
            Quantity<U> quantity2,
            U targetUnit) {

        return quantity1.add(quantity2, targetUnit);
    }


    // uc12: subtraction and division operations
    // Demonstrates subtraction with the first operand's unit
    public static <U extends IMeasurable> Quantity<U>
    demonstrateSubtraction(Quantity<U> quantity1, Quantity<U> quantity2) {

        return quantity1.subtract(quantity2);
    }

    // Demonstrates subtraction with an explicitly specified target unit
    public static <U extends IMeasurable> Quantity<U>
    demonstrateSubtraction(
            Quantity<U> quantity1,
            Quantity<U> quantity2,
            U targetUnit) {

        return quantity1.subtract(quantity2, targetUnit);
    }


    // uc12: subtraction and division operations
    // Demonstrates division between two quantities
    public static <U extends IMeasurable> double
    demonstrateDivision(Quantity<U> quantity1, Quantity<U> quantity2) {

        return quantity1.divide(quantity2);
    }

    // Main method
    // uc10: generic quantity class with unit interface
    public static void main(String[] args) {
        // uc12: subtraction and division operations

        // SUBTRACTION OPERATIONS

        // Feet - Inches (implicit target unit)
        Quantity<LengthUnit> subtraction1 =
                new Quantity<>(10.0, LengthUnit.FEET);

        Quantity<LengthUnit> subtraction2 =
                new Quantity<>(6.0, LengthUnit.INCHES);

        System.out.println("Subtraction (Feet): "
                + demonstrateSubtraction(subtraction1, subtraction2));

        // Feet - Inches (explicit target unit)
        System.out.println("Subtraction (Inches): "
                + demonstrateSubtraction(
                subtraction1, subtraction2, LengthUnit.INCHES));

        // Subtraction resulting in a negative value
        System.out.println("Negative subtraction: "
                + demonstrateSubtraction(
                new Quantity<>(5.0, LengthUnit.FEET),
                new Quantity<>(10.0, LengthUnit.FEET)));

        // Weight subtraction
        System.out.println("Weight subtraction: "
                + demonstrateSubtraction(
                new Quantity<>(10.0, WeightUnit.KILOGRAM),
                new Quantity<>(5000.0, WeightUnit.GRAM)));

        // Volume subtraction
        System.out.println("Volume subtraction: "
                + demonstrateSubtraction(
                new Quantity<>(5.0, VolumeUnit.LITRE),
                new Quantity<>(500.0, VolumeUnit.MILLILITRE)));


        // DIVISION OPERATIONS

        // Same-unit division
        System.out.println("Feet division: "
                + demonstrateDivision(
                new Quantity<>(10.0, LengthUnit.FEET),
                new Quantity<>(2.0, LengthUnit.FEET)));

        // Different-unit division
        System.out.println("Cross-unit division: "
                + demonstrateDivision(
                new Quantity<>(24.0, LengthUnit.INCHES),
                new Quantity<>(2.0, LengthUnit.FEET)));

        // Weight division
        System.out.println("Weight division: "
                + demonstrateDivision(
                new Quantity<>(2000.0, WeightUnit.GRAM),
                new Quantity<>(1.0, WeightUnit.KILOGRAM)));

        // Volume division
        System.out.println("Volume division: "
                + demonstrateDivision(
                new Quantity<>(5.0, VolumeUnit.LITRE),
                new Quantity<>(10.0, VolumeUnit.LITRE)));
    }
}