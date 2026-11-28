
package com.bridgelabz;

import java.util.function.DoubleBinaryOperator;

// uc15: n-tier architecture refactoring

public class QuantityMeasurementServiceImpl
        implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    // Initializes the service with the repository dependency
    public QuantityMeasurementServiceImpl(
            IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }


    // uc15: n-tier architecture refactoring
    // Compares two quantities after converting them into their base units
    @Override
    public boolean compare(QuantityDTO thisQuantityDTO,
                           QuantityDTO thatQuantityDTO) {

        QuantityModel<?> first = getQuantityModel(thisQuantityDTO);
        QuantityModel<?> second = getQuantityModel(thatQuantityDTO);

        boolean result = toQuantity(first).equals(toQuantity(second));

        repository.save(new QuantityMeasurementEntity(
                first, second, "COMPARE",
                result ? "Equal" : "Not Equal"));

        return result;
    }


    // uc15: n-tier architecture refactoring
    // Converts a quantity into the target unit
    @Override
    public QuantityDTO convert(QuantityDTO thisQuantityDTO,
                               QuantityDTO thatQuantityDTO) {

        QuantityModel<?> source = getQuantityModel(thisQuantityDTO);
        QuantityModel<?> target = getQuantityModel(thatQuantityDTO);

        Quantity result = toQuantity(source).convertTo(target.getUnit());

        QuantityModel<?> resultModel =
                new QuantityModel<>(result.getValue(), result.getUnit());

        repository.save(new QuantityMeasurementEntity(
                source, target, "CONVERT", resultModel));

        return toDTO(result);
    }


    // uc15: n-tier architecture refactoring
    // Adds two quantities using the first quantity's unit
    @Override
    public QuantityDTO add(QuantityDTO thisQuantityDTO,
                           QuantityDTO thatQuantityDTO) {

        QuantityModel<?> first = getQuantityModel(thisQuantityDTO);
        QuantityModel<?> second = getQuantityModel(thatQuantityDTO);

        Quantity result = toQuantity(first).add(toQuantity(second));

        QuantityModel<?> resultModel =
                new QuantityModel<>(result.getValue(), result.getUnit());

        repository.save(new QuantityMeasurementEntity(
                first, second, "ADD", resultModel));

        return toDTO(result);
    }


    // uc15: n-tier architecture refactoring
    // Adds two quantities using the specified target unit
    @Override
    public QuantityDTO add(QuantityDTO thisQuantityDTO,
                           QuantityDTO thatQuantityDTO,
                           QuantityDTO targetUnitDTO) {

        QuantityModel<?> first = getQuantityModel(thisQuantityDTO);
        QuantityModel<?> second = getQuantityModel(thatQuantityDTO);
        QuantityModel<?> target = getQuantityModel(targetUnitDTO);

        Quantity result = toQuantity(first).add(
                toQuantity(second), target.getUnit());

        QuantityModel<?> resultModel =
                new QuantityModel<>(result.getValue(), result.getUnit());

        repository.save(new QuantityMeasurementEntity(
                first, second, "ADD", resultModel));

        return toDTO(result);
    }


    // uc15: n-tier architecture refactoring
    // Subtracts two quantities using the first quantity's unit
    @Override
    public QuantityDTO subtract(QuantityDTO thisQuantityDTO,
                                QuantityDTO thatQuantityDTO) {

        QuantityModel<?> first = getQuantityModel(thisQuantityDTO);
        QuantityModel<?> second = getQuantityModel(thatQuantityDTO);

        Quantity result = toQuantity(first).subtract(toQuantity(second));

        QuantityModel<?> resultModel =
                new QuantityModel<>(result.getValue(), result.getUnit());

        repository.save(new QuantityMeasurementEntity(
                first, second, "SUBTRACT", resultModel));

        return toDTO(result);
    }


    // uc15: n-tier architecture refactoring
    // Subtracts two quantities using the specified target unit
    @Override
    public QuantityDTO subtract(QuantityDTO thisQuantityDTO,
                                QuantityDTO thatQuantityDTO,
                                QuantityDTO targetUnitDTO) {

        QuantityModel<?> first = getQuantityModel(thisQuantityDTO);
        QuantityModel<?> second = getQuantityModel(thatQuantityDTO);
        QuantityModel<?> target = getQuantityModel(targetUnitDTO);

        Quantity result = toQuantity(first).subtract(
                toQuantity(second), target.getUnit());

        QuantityModel<?> resultModel =
                new QuantityModel<>(result.getValue(), result.getUnit());

        repository.save(new QuantityMeasurementEntity(
                first, second, "SUBTRACT", resultModel));

        return toDTO(result);
    }

    // uc15: n-tier architecture refactoring
    // Divides two quantities and returns a dimensionless result
    @Override
    public double divide(QuantityDTO thisQuantityDTO,
                         QuantityDTO thatQuantityDTO) {

        QuantityModel<?> first = getQuantityModel(thisQuantityDTO);
        QuantityModel<?> second = getQuantityModel(thatQuantityDTO);

        double result = toQuantity(first).divide(toQuantity(second));

        repository.save(new QuantityMeasurementEntity(
                first, second, "DIVIDE", result));

        return result;
    }

    // uc15: n-tier architecture refactoring
    // Converts a DTO into its corresponding quantity model
    private QuantityModel<? extends IMeasurable> getQuantityModel(
            QuantityDTO quantity) {

        if (quantity == null || quantity.getUnit() == null
                || quantity.getMeasurementType() == null) {
            throw new IllegalArgumentException("Invalid quantity DTO");
        }

        IMeasurable unit;

        switch (quantity.getMeasurementType()) {

            case "LengthUnit":
                unit = LengthUnit.FEET.getUnitInstance(quantity.getUnit());
                break;

            case "WeightUnit":
                unit = WeightUnit.GRAM.getUnitInstance(quantity.getUnit());
                break;

            case "VolumeUnit":
                unit = VolumeUnit.LITRE.getUnitInstance(quantity.getUnit());
                break;

            case "TemperatureUnit":
                unit = TemperatureUnit.CELSIUS.getUnitInstance(quantity.getUnit());
                break;

            default:
                throw new IllegalArgumentException(
                        "Unsupported measurement type");
        }

        return new QuantityModel<>(quantity.getValue(), unit);
    }

    // uc15: n-tier architecture refactoring
    // Converts a quantity model into the existing generic Quantity object
    @SuppressWarnings({"rawtypes", "unchecked"})
    private Quantity toQuantity(QuantityModel<?> model) {
        return new Quantity(model.getValue(), model.getUnit());
    }

    // uc15: n-tier architecture refactoring
    // Converts a generic quantity into a DTO
    private QuantityDTO toDTO(Quantity<?> quantity) {

        return new QuantityDTO(
                quantity.getValue(),
                quantity.getUnit().getUnitName(),
                quantity.getUnit().getMeasurementType());
    }

}
