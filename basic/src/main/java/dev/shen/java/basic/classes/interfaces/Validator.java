package dev.shen.java.basic.classes.interfaces;

// Functional interface (has exactly one abstract method)
@FunctionalInterface
public interface Validator {
    boolean validate(String input);

    // Can still have default and static methods
    default void printError(String input) {
        if (!validate(input)) {
            System.out.println("Validation failed for: " + input);
        }
    }
}
