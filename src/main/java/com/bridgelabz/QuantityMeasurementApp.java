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

        // LENGTH OPERATIONS

        Quantity<LengthUnit> lengthInFeet =
                new Quantity<>(1.0, LengthUnit.FEET);

        Quantity<LengthUnit> lengthInInches =
                new Quantity<>(12.0, LengthUnit.INCHES);

        // Length equality
        System.out.println("Length equality: "
                + demonstrateEquality(lengthInFeet, lengthInInches));

        // Length conversion
        System.out.println("Length conversion: "
                + demonstrateConversion(
                lengthInFeet, LengthUnit.INCHES));

        // Length addition
        System.out.println("Length addition: "
                + demonstrateAddition(
                lengthInFeet, lengthInInches, LengthUnit.FEET));


        // WEIGHT OPERATIONS

        Quantity<WeightUnit> weightInKg =
                new Quantity<>(1.0, WeightUnit.KILOGRAM);

        Quantity<WeightUnit> weightInGrams =
                new Quantity<>(1000.0, WeightUnit.GRAM);

        // Weight equality
        System.out.println("Weight equality: "
                + demonstrateEquality(weightInKg, weightInGrams));

        // Weight conversion
        System.out.println("Weight conversion: "
                + demonstrateConversion(
                weightInKg, WeightUnit.GRAM));

        // Weight addition
        System.out.println("Weight addition: "
                + demonstrateAddition(
                weightInKg, weightInGrams, WeightUnit.KILOGRAM));


        // CROSS-CATEGORY COMPARISON

        System.out.println("Cross-category equality: "
                + demonstrateEquality(lengthInFeet, weightInKg));
    }


}