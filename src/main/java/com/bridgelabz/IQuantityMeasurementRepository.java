package com.bridgelabz;

import java.util.List;

// uc15: n-tier architecture refactoring

public interface IQuantityMeasurementRepository {

    // Saves a measurement entity
    void save(QuantityMeasurementEntity entity);

    // Retrieves all measurement entities
    List<QuantityMeasurementEntity> getAllMeasurements();
}
