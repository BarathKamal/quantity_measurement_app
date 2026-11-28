## Quantity Measurement App

### Description

The Quantity Measurement App compares quantities such as length, weight, and volume across different units. It supports equality comparison, unit conversion, and quantity arithmetic through incremental use-case-based development.

#### Use Case 1: Feet Measurement Equality

Compare two numerical values measured in feet and determine whether they are equal.

#### Use Case 2: Feet and Inches Measurement Equality

Extend the application to compare two Feet measurements and two Inches measurements independently using separate equality methods.

#### Use Case 3: Generic Quantity Class for DRY Principle

Refactor the separate Feet and Inches classes into a single generic Length class to eliminate code duplication and support equality comparisons across different units.

#### Use Case 4: Extended Unit Support

Extend the Length class to support Yards and Centimeters by adding their conversion factors, enabling equality comparisons across all four length units.

#### Use Case 5: Unit-to-Unit Conversion (Same Measurement Type)

Implement conversion operations between Feet, Inches, Yards, and Centimeters using centralized conversion factors, supporting both static and instance-based conversion methods.

#### Use Case 6: Addition of Two Length Units (Same Category)

Extend the application to perform addition between two length measurements, including different units, returning the result in the unit of the first operand.

#### Use Case 7: Addition with Target Unit Specification

Extend the addition functionality to allow users to explicitly specify the target unit in which the addition result should be returned.

#### Use Case 8: Refactoring Unit Enum to Standalone with Conversion Responsibility

Refactor the LengthUnit enum into a standalone class and delegate unit conversion responsibilities to it, improving separation of concerns, reducing coupling, and supporting scalability.

#### Use Case 9: Weight Measurement Equality, Conversion, and Addition (Kilogram, Gram, Pound)

Extend the Quantity Measurement App to support weight measurements by implementing equality comparison, unit conversion, and addition across Kilogram, Gram, and Pound while keeping weight and length categories independent.

#### Use Case 10: Generic Quantity Class with Unit Interface for Multi-Category Support

Refactor the application using a generic Quantity class and IMeasurable interface to eliminate code duplication, maintain type safety, and support multiple measurement categories through a unified implementation.

#### Use Case 11: Volume Measurement Equality, Conversion, and Addition (Litre, Millilitre, Gallon)

Extend the Quantity Measurement App to support volume measurements by implementing equality comparison, unit conversion, and addition across Litre, Millilitre, and Gallon using the existing generic Quantity class and IMeasurable interface.

#### Use Case 12: Subtraction and Division Operations on Quantity Measurements

Extend the generic Quantity class to support subtraction and division across Length, Weight, and Volume measurements, including cross-unit arithmetic, target unit specification, and appropriate error handling.

#### Use Case 13: Centralized Arithmetic Logic to Enforce DRY in Quantity Operations

Refactor addition, subtraction, and division operations by introducing centralized validation and arithmetic helper methods, eliminating code duplication while preserving existing functionality and public method signatures.

#### Use Case 14: Temperature Measurement with Selective Arithmetic Support and IMeasurable Refactoring

Extend the Quantity Measurement App to support Celsius, Fahrenheit, and Kelvin conversions while refactoring IMeasurable to provide selective arithmetic support, preventing unsupported operations on temperature measurements.

#### Use Case 15: N-Tier Architecture Refactoring

Refactor the Quantity Measurement Application into a four-tier architecture by separating application, controller, service, and entity/model responsibilities.