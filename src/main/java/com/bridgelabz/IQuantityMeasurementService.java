package com.bridgelabz;

// uc15: n-tier architecture refactoring

public interface IQuantityMeasurementService {

    // Compares two quantities
    boolean compare(QuantityDTO thisQuantityDTO,
                    QuantityDTO thatQuantityDTO);

    // Converts a quantity into another unit
    QuantityDTO convert(QuantityDTO thisQuantityDTO,
                        QuantityDTO thatQuantityDTO);

    // Adds two quantities using the first quantity's unit
    QuantityDTO add(QuantityDTO thisQuantityDTO,
                    QuantityDTO thatQuantityDTO);

    // Adds two quantities using the specified target unit
    QuantityDTO add(QuantityDTO thisQuantityDTO,
                    QuantityDTO thatQuantityDTO,
                    QuantityDTO targetUnitDTO);

    // Subtracts two quantities using the first quantity's unit
    QuantityDTO subtract(QuantityDTO thisQuantityDTO,
                         QuantityDTO thatQuantityDTO);

    // Subtracts two quantities using the specified target unit
    QuantityDTO subtract(QuantityDTO thisQuantityDTO,
                         QuantityDTO thatQuantityDTO,
                         QuantityDTO targetUnitDTO);

    // Divides two quantities and returns a dimensionless result
    double divide(QuantityDTO thisQuantityDTO,
                  QuantityDTO thatQuantityDTO);
}
