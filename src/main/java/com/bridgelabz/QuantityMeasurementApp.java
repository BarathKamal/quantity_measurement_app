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

    // Main method
    // uc10: generic quantity class with unit interface
    public static void main(String[] args) {

        // uc11: volume measurement equality, conversion, and addition

        // Volume measurements
        Quantity<VolumeUnit> volume1 =
                new Quantity<>(1.0, VolumeUnit.LITRE);

        Quantity<VolumeUnit> volume2 =
                new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

        Quantity<VolumeUnit> volume3 =
                new Quantity<>(1.0, VolumeUnit.GALLON);

        // Volume equality
        System.out.println("Volume equality: "
                + demonstrateEquality(volume1, volume2));

        // Cross-unit volume equality
        System.out.println("Litre and Gallon equality: "
                + demonstrateEquality(
                volume1,
                new Quantity<>(0.264172, VolumeUnit.GALLON)));

        // Volume conversion
        System.out.println("Volume conversion: "
                + demonstrateConversion(
                volume1, VolumeUnit.MILLILITRE));

        // Addition with implicit target unit
        System.out.println("Volume addition: "
                + demonstrateAddition(volume1, volume2));

        // Addition with explicit target unit
        System.out.println("Volume addition in Gallons: "
                + demonstrateAddition(
                volume1, volume2, VolumeUnit.GALLON));

    }

}