package dev.shen.java.basic.classes.inheritance;

public class Vehicle {
    private final String make;
    private final String model;
    private final int year;

    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void start() {
        System.out.println("Vehicle starting...");
    }

    public void stop() {
        System.out.println("Vehicle stopping...");
    }

    /*
    The toString() method is part of the Object class in Java, which is the root class for all Java classes.
    Every class in Java inherits from Object either directly or indirectly,
    which means every class automatically has a toString() method.
    By default, the toString() method from the Object class returns a string representation of the object
    in the format: className@hashCode. For example: Vehicle@7852e922
     */
    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}
