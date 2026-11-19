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

