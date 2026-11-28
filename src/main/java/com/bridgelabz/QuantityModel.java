
package com.bridgelabz;

// uc15: n-tier architecture refactoring

public class QuantityModel<U extends IMeasurable> {

    public double value;
    public U unit;

    // Initializes the quantity model
    public QuantityModel(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    // Returns the measurement value
    public double getValue() {
        return value;
    }

    // Returns the measurement unit
    public U getUnit() {
        return unit;
    }

    // Returns the quantity model details
    @Override
    public String toString() {
        return value + " " + unit.getUnitName();
    }
}
