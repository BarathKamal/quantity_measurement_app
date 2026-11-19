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

    // Main method
    public static void main(String[] args) {

        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);

        System.out.println("Are both measurements equal? "
                + feet1.equals(feet2));
    }
}