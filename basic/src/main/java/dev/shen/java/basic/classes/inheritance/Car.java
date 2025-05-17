package dev.shen.java.basic.classes.inheritance;

public class Car extends Vehicle {
    private final int numberOfDoors;

    public Car(String make, String model, int year, int numberOfDoors) {
        super(make, model, year);  // call parent constructor
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    // Override parent method
    @Override
    public void start() {
        System.out.println("Car engine starting with key...");
    }

    public static void main(String[] args){
        Car car = new Car("Tesla", "X", 2019, 5);
        System.out.println("The car is: " + car);
        System.out.println("The car has: " + car.getNumberOfDoors() + " doors.");
        car.start();
        car.stop();
    }
}


