package dev.shen.java.basic.classes.interfaces;

public interface Drawable {
    void draw(); // Abstract method (no implementation)

    // Default method (with implementation, added in Java 8)
    default void displayInfo() {
        System.out.println("This is a drawable object");
    }
}
