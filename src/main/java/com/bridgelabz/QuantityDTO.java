package com.bridgelabz;

// uc15: n-tier architecture refactoring

public class QuantityDTO {

    // Represents measurable units in the DTO layer
    public interface IMeasurableUnit {
        String getUnitName();
        String getMeasurementType();
    }

    // Represents length units
    public enum LengthUnit implements IMeasurableUnit {
        FEET, INCHES, YARDS, CENTIMETERS, METERS;

        // Returns the unit name
        @Override
        public String getUnitName() {
            return name();
        }

        // Returns the measurement category
        @Override
        public String getMeasurementType() {
            return getClass().getSimpleName();
        }
    }

    // Represents weight units
    public enum WeightUnit implements IMeasurableUnit {
        GRAM, KILOGRAM, POUND, OUNCE;

        // Returns the unit name
        @Override
        public String getUnitName() {
            return name();
        }

        // Returns the measurement category
        @Override
        public String getMeasurementType() {
            return getClass().getSimpleName();
        }
    }

    // Represents volume units
    public enum VolumeUnit implements IMeasurableUnit {
        LITRE, MILLILITRE, GALLON;

        // Returns the unit name
        @Override
        public String getUnitName() {
            return name();
        }

        // Returns the measurement category
        @Override
        public String getMeasurementType() {
            return getClass().getSimpleName();
        }
    }

    // Represents temperature units
    public enum TemperatureUnit implements IMeasurableUnit {
        CELSIUS, FAHRENHEIT, KELVIN;

        // Returns the unit name
        @Override
        public String getUnitName() {
            return name();
        }

        // Returns the measurement category
        @Override
        public String getMeasurementType() {
            return getClass().getSimpleName();
        }
    }

    public double value;
    public String unit;
    public String measurementType;

    // Initializes DTO using a measurable unit
    public QuantityDTO(double value, IMeasurableUnit unit) {
        this.value = value;
        this.unit = unit.getUnitName();
        this.measurementType = unit.getMeasurementType();
    }

    // Initializes DTO using unit and measurement type strings
    public QuantityDTO(double value, String unit, String measurementType) {
        this.value = value;
        this.unit = unit;
        this.measurementType = measurementType;
    }

    // Returns the measurement value
    public double getValue() {
        return value;
    }

    // Returns the unit name
    public String getUnit() {
        return unit;
    }

    // Returns the measurement type
    public String getMeasurementType() {
        return measurementType;
    }

    // Returns the DTO details
    @Override
    public String toString() {
        return value + " " + unit;
    }
}
