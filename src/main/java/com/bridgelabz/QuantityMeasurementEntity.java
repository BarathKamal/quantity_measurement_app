package com.bridgelabz;

import java.io.Serializable;
import java.util.Objects;

// uc15: n-tier architecture refactoring

public class QuantityMeasurementEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    public double thisValue;
    public String thisUnit;
    public String thisMeasurementType;

    public double thatValue;
    public String thatUnit;
    public String thatMeasurementType;

    public String operation;

    public double resultValue;
    public String resultUnit;
    public String resultMeasurementType;

    public String resultString;

    public boolean isError;
    public String errorMessage;

    // Initializes an entity for a single-operand operation
    public QuantityMeasurementEntity(
            QuantityModel<? extends IMeasurable> thisQuantity,
            QuantityModel<? extends IMeasurable> thatQuantity,
            String operation,
            String result) {

        this(thisQuantity, thatQuantity, operation);
        this.resultString = result;
    }

    // Initializes an entity for a binary arithmetic operation
    public QuantityMeasurementEntity(
            QuantityModel<? extends IMeasurable> thisQuantity,
            QuantityModel<? extends IMeasurable> thatQuantity,
            String operation,
            QuantityModel<? extends IMeasurable> result) {

        this(thisQuantity, thatQuantity, operation);

        this.resultValue = result.getValue();
        this.resultUnit = result.getUnit().getUnitName();
        this.resultMeasurementType =
                result.getUnit().getMeasurementType();
    }

    // Initializes an entity for an arithmetic result
    public QuantityMeasurementEntity(
            QuantityModel<? extends IMeasurable> thisQuantity,
            QuantityModel<? extends IMeasurable> thatQuantity,
            String operation,
            double result) {

        this(thisQuantity, thatQuantity, operation);
        this.resultValue = result;
    }

    // Initializes an entity for an operation error
    public QuantityMeasurementEntity(
            QuantityModel<? extends IMeasurable> thisQuantity,
            QuantityModel<? extends IMeasurable> thatQuantity,
            String operation,
            String errorMessage,
            boolean isError) {

        this(thisQuantity, thatQuantity, operation);
        this.errorMessage = errorMessage;
        this.isError = isError;
    }

    // Initializes the common operand and operation details
    private QuantityMeasurementEntity(
            QuantityModel<? extends IMeasurable> thisQuantity,
            QuantityModel<? extends IMeasurable> thatQuantity,
            String operation) {

        this.thisValue = thisQuantity.getValue();
        this.thisUnit = thisQuantity.getUnit().getUnitName();
        this.thisMeasurementType =
                thisQuantity.getUnit().getMeasurementType();

        if (thatQuantity != null) {
            this.thatValue = thatQuantity.getValue();
            this.thatUnit = thatQuantity.getUnit().getUnitName();
            this.thatMeasurementType =
                    thatQuantity.getUnit().getMeasurementType();
        }

        this.operation = operation;
    }

    // Compares measurement entities based on their stored fields
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof QuantityMeasurementEntity)) return false;

        QuantityMeasurementEntity other =
                (QuantityMeasurementEntity) obj;

        return Double.compare(thisValue, other.thisValue) == 0
                && Double.compare(thatValue, other.thatValue) == 0
                && Double.compare(resultValue, other.resultValue) == 0
                && isError == other.isError
                && Objects.equals(thisUnit, other.thisUnit)
                && Objects.equals(thatUnit, other.thatUnit)
                && Objects.equals(operation, other.operation)
                && Objects.equals(resultString, other.resultString)
                && Objects.equals(errorMessage, other.errorMessage);
    }

    // Returns a readable representation of the measurement operation
    @Override
    public String toString() {
        if (isError) {
            return "Error: " + errorMessage;
        }

        return operation + ": " + thisValue + " " + thisUnit
                + (thatUnit == null ? "" : " and " + thatValue + " " + thatUnit)
                + " = " + (resultString != null
                ? resultString : resultValue + " " + resultUnit);
    }
}
