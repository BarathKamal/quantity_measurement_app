package com.bridgelabz;

// uc15: n-tier architecture refactoring

public class QuantityMeasurementApp {

    private static QuantityMeasurementApp instance;

    private final QuantityMeasurementController controller;
    private final IQuantityMeasurementRepository repository;

    // Initializes repository, service, and controller dependencies
    private QuantityMeasurementApp() {
        this.repository = QuantityMeasurementCacheRepository.getInstance();

        IQuantityMeasurementService service =
                new QuantityMeasurementServiceImpl(this.repository);

        this.controller = new QuantityMeasurementController(service);
    }

    // Returns the singleton application instance
    public static QuantityMeasurementApp getInstance() {
        if (instance == null) {
            instance = new QuantityMeasurementApp();
        }
        return instance;
    }

    // Returns the controller instance
    public QuantityMeasurementController getController() {
        return controller;
    }

    // Returns the repository instance
    public IQuantityMeasurementRepository getRepository() {
        return repository;
    }

    // Application entry point
    public static void main(String[] args) {

        QuantityMeasurementApp app = QuantityMeasurementApp.getInstance();

        QuantityMeasurementController controller = app.getController();

        QuantityDTO quantity1 =
                new QuantityDTO(5.0, "FEET", "LengthUnit");

        QuantityDTO quantity2 =
                new QuantityDTO(10.0, "INCHES", "LengthUnit");

        // Demonstrates quantity comparison
        System.out.println("Comparison: "
                + controller.performComparison(quantity1, quantity2));

        // Demonstrates quantity conversion
        System.out.println("Conversion: "
                + controller.performConversion(quantity1,
                new QuantityDTO(0, "INCHES", "LengthUnit")));

        // Demonstrates addition
        System.out.println("Addition: "
                + controller.performAddition(quantity1, quantity2));

        // Demonstrates subtraction
        System.out.println("Subtraction: "
                + controller.performSubtraction(quantity1, quantity2));

        // Demonstrates division
        System.out.println("Division: "
                + controller.performDivision(quantity1, quantity2));
    }
}