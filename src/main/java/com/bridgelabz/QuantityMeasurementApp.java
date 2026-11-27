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

        // uc14: temperature measurement with selective arithmetic support and IMeasurable refactoring
        System.out.println("\n=== Temperature Demonstration ===");

        // Temperature equality
        Quantity<TemperatureUnit> temperature1 =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> temperature2 =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        System.out.println("Temperature equality: "
                + demonstrateEquality(temperature1, temperature2));

        // Celsius to Fahrenheit conversion
        Quantity<TemperatureUnit> celsius =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        System.out.println("Celsius to Fahrenheit: "
                + demonstrateConversion(
                celsius, TemperatureUnit.FAHRENHEIT));

        // Fahrenheit to Celsius conversion
        Quantity<TemperatureUnit> fahrenheit =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        System.out.println("Fahrenheit to Celsius: "
                + demonstrateConversion(
                fahrenheit, TemperatureUnit.CELSIUS));

        // Celsius to Kelvin conversion
        System.out.println("Celsius to Kelvin: "
                + demonstrateConversion(
                temperature1, TemperatureUnit.KELVIN));

        // Unsupported addition
        try {
            temperature1.add(temperature2);
        } catch (UnsupportedOperationException e) {
            System.out.println("Addition error: " + e.getMessage());
        }

        // Unsupported subtraction
        try {
            temperature1.subtract(temperature2);
        } catch (UnsupportedOperationException e) {
            System.out.println("Subtraction error: " + e.getMessage());
        }

        // Unsupported division
        try {
            temperature1.divide(temperature2);
        } catch (UnsupportedOperationException e) {
            System.out.println("Division error: " + e.getMessage());
        }

        // Arithmetic support verification
        System.out.println("Temperature arithmetic supported: "
                + TemperatureUnit.CELSIUS.supportsArithmetic());

        System.out.println("Length arithmetic supported: "
                + LengthUnit.FEET.supportsArithmetic());
    }
}