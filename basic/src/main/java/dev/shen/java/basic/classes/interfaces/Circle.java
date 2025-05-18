package dev.shen.java.basic.classes.interfaces;

public class Circle implements Drawable{
    private final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    // Must implement the abstract method
    @Override
    public void draw() {
        System.out.println("Drawing Circle with radius " + radius + " ...");
    }

    public void done() {
        System.out.println("Circle done.");
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.displayInfo();
        circle.draw();
        circle.done();
    }
}
