
package com.bridgelabz;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// uc15: n-tier architecture refactoring

public class QuantityMeasurementCacheRepository
        implements IQuantityMeasurementRepository {

    public static final String FILE_NAME = "quantity_measurement_repo.ser";

    private final List<QuantityMeasurementEntity> quantityMeasurementEntityCache;

    private static QuantityMeasurementCacheRepository instance;

    // Initializes the cache and loads existing records
    private QuantityMeasurementCacheRepository() {
        quantityMeasurementEntityCache = new ArrayList<>();
        loadFromDisk();
    }

    // Returns the singleton repository instance
    public static QuantityMeasurementCacheRepository getInstance() {
        if (instance == null) {
            instance = new QuantityMeasurementCacheRepository();
        }
        return instance;
    }

    // Saves an entity in the cache and persists it
    @Override
    public void save(QuantityMeasurementEntity entity) {
        quantityMeasurementEntityCache.add(entity);
        saveToDisk(entity);
    }

    // Returns all stored measurement entities
    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {
        return new ArrayList<>(quantityMeasurementEntityCache);
    }

    // Saves an entity to the existing serialized file
    private void saveToDisk(QuantityMeasurementEntity entity) {
        try {
            File file = new File(FILE_NAME);
            boolean append = file.exists() && file.length() > 0;

            try (FileOutputStream fos =
                         new FileOutputStream(file, true);
                 ObjectOutputStream oos = append
                         ? new AppendableObjectOutputStream(fos)
                         : new ObjectOutputStream(fos)) {

                oos.writeObject(entity);
            }

        } catch (IOException e) {
            System.err.println("Error saving entity: " + e.getMessage());
        }
    }

    // Loads previously stored entities from disk
    private void loadFromDisk() {
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            return;
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            while (true) {
                try {
                    QuantityMeasurementEntity entity =
                            (QuantityMeasurementEntity) ois.readObject();

                    quantityMeasurementEntityCache.add(entity);

                } catch (EOFException e) {
                    break;
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading entities: " + e.getMessage());
        }
    }

    // Prevents writing another stream header when appending objects
    private static class AppendableObjectOutputStream
            extends ObjectOutputStream {

        // Initializes the appendable output stream
        AppendableObjectOutputStream(OutputStream output)
                throws IOException {
            super(output);
        }

        // Prevents duplicate serialization headers
        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }
}

