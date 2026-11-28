package com.bridgelabz;

// uc15: n-tier architecture refactoring

public class QuantityMeasurementController {

    private final IQuantityMeasurementService quantityMeasurementService;

    // Initializes the controller with the service dependency
    public QuantityMeasurementController(
            IQuantityMeasurementService quantityMeasurementService) {
        this.quantityMeasurementService = quantityMeasurementService;
    }

    // Performs comparison between two quantities
    public boolean performComparison(
            QuantityDTO thisQuantityDTO,
            QuantityDTO thatQuantityDTO) {
        return quantityMeasurementService.compare(
                thisQuantityDTO, thatQuantityDTO);
    }

    // Converts a quantity into the target unit
    public QuantityDTO performConversion(
            QuantityDTO thisQuantityDTO,
            QuantityDTO thatQuantityDTO) {
        return quantityMeasurementService.convert(
                thisQuantityDTO, thatQuantityDTO);
    }

    // Adds two quantities
    public QuantityDTO performAddition(
            QuantityDTO thisQuantityDTO,
            QuantityDTO thatQuantityDTO) {
        return quantityMeasurementService.add(
                thisQuantityDTO, thatQuantityDTO);
    }

    // Adds two quantities and returns the result in the target unit
    public QuantityDTO performAddition(
            QuantityDTO thisQuantityDTO,
            QuantityDTO thatQuantityDTO,
            QuantityDTO targetUnitDTO) {
        return quantityMeasurementService.add(
                thisQuantityDTO, thatQuantityDTO, targetUnitDTO);
    }

    // Subtracts two quantities
    public QuantityDTO performSubtraction(
            QuantityDTO thisQuantityDTO,
            QuantityDTO thatQuantityDTO) {
        return quantityMeasurementService.subtract(
                thisQuantityDTO, thatQuantityDTO);
    }

    // Subtracts two quantities and returns the result in the target unit
    public QuantityDTO performSubtraction(
            QuantityDTO thisQuantityDTO,
            QuantityDTO thatQuantityDTO,
            QuantityDTO targetUnitDTO) {
        return quantityMeasurementService.subtract(
                thisQuantityDTO, thatQuantityDTO, targetUnitDTO);
    }

    // Divides two quantities
    public double performDivision(
            QuantityDTO thisQuantityDTO,
            QuantityDTO thatQuantityDTO) {
        return quantityMeasurementService.divide(
                thisQuantityDTO, thatQuantityDTO);
    }
}