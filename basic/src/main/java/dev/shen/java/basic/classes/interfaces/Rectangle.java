package dev.shen.java.basic.classes.interfaces;

public class Rectangle implements Drawable {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with width " + width +
                " and height " + height);
    }

    // Override the default method
    @Override
    public void displayInfo() {
        System.out.println("This is a rectangle with dimensions " +
                width + "x" + height);
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10);
        rectangle.displayInfo();
        rectangle.draw();
    }
}
