package com.bridgelabz;

public class QuantityMeasurementApp {

    // uc1: feet measurement equality
    // Inner class representing a feet measurement
    public static class Feet {

        private final double value;

        // Initializes the feet measurement
        public Feet(double value) {
            this.value = value;
        }

        // Compares two Feet objects based on their values
        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Feet other = (Feet) obj;

            return Double.compare(this.value, other.value) == 0;
        }
    }

    // uc2: feet and inches measurement equality
    // Inner class to represent Inches measurement
    public static class Inches {

        private final double value;

        // Initializes the inches measurement
        public Inches(double value) {
            this.value = value;
        }

        // Compares two Inches objects based on their values
        @Override
        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Inches other = (Inches) obj;

            return Double.compare(this.value, other.value) == 0;
        }
    }


    // uc2: feet and inches measurement equality
    // Demonstrates equality comparison between Feet measurements
    public static void demonstrateFeetEquality() {

        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        System.out.println("Feet measurements equal: "
                + feet1.equals(feet2));
    }

    // uc2: feet and inches measurement equality
    // Demonstrates equality comparison between Inches measurements
    public static void demonstrateInchesEquality() {

        Inches inches1 = new Inches(1.0);
        Inches inches2 = new Inches(1.0);

        System.out.println("Inches measurements equal: "
                + inches1.equals(inches2));
    }


    // Main method
    public static void main(String[] args) {

        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        System.out.println("Are both measurements equal? "
                + feet1.equals(feet2));
    }
}