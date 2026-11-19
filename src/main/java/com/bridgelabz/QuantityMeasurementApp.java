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

    // uc9: weight measurement equality, conversion, and addition
    // Compares two weight measurements for equality
    public static boolean demonstrateWeightEquality(
            QuantityWeight weight1, QuantityWeight weight2) {

        return weight1.equals(weight2);
    }

    // Demonstrates conversion between two weight units
    public static QuantityWeight demonstrateWeightConversion(
            double value, WeightUnit fromUnit, WeightUnit toUnit) {

        QuantityWeight weight = new QuantityWeight(value, fromUnit);
        return weight.convertTo(toUnit);
    }

    // Converts an existing weight object into the target unit
    public static QuantityWeight demonstrateWeightConversion(
            QuantityWeight weight, WeightUnit targetUnit) {

        return weight.convertTo(targetUnit);
    }

    // Adds two weights and returns the result in the first operand's unit
    public static QuantityWeight demonstrateWeightAddition(
            QuantityWeight weight1, QuantityWeight weight2) {

        return weight1.add(weight2);
    }

    // Adds two weights and returns the result in the specified target unit
    public static QuantityWeight demonstrateWeightAddition(
            QuantityWeight weight1, QuantityWeight weight2,
            WeightUnit targetUnit) {

        return weight1.add(weight2, targetUnit);
    }

    // Main method
    public static void main(String[] args) {

        // Weight equality
        QuantityWeight weight1 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight weight2 =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println("Weight equality: "
                + demonstrateWeightEquality(weight1, weight2));

        // Weight conversion
        System.out.println("Weight conversion: "
                + demonstrateWeightConversion(
                2.0, WeightUnit.POUND, WeightUnit.KILOGRAM));

        // Addition with implicit target unit
        QuantityWeight weight3 =
                new QuantityWeight(1.0, WeightUnit.KILOGRAM);

        QuantityWeight weight4 =
                new QuantityWeight(1000.0, WeightUnit.GRAM);

        System.out.println("Weight addition: "
                + demonstrateWeightAddition(weight3, weight4));

        // Addition with explicit target unit
        System.out.println("Weight addition with target unit: "
                + demonstrateWeightAddition(
                weight3, weight4, WeightUnit.GRAM));
    }

}