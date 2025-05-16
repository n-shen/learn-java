package dev.shen.java.basic.introduction.helloworld;

/**
 * A Hello World example that uses command-line arguments.
 * This class demonstrates:
 * - Accessing command-line arguments
 * - Basic string concatenation
 * - Conditional logic
 */
public class HelloWorldArgs {

    /**
     * Main method that uses command-line arguments.
     *
     * @param args Command line arguments - expects a name as the first argument
     */
    public static void main(String[] args) {
        // Check if any arguments were provided
        if (args.length > 0) {
            // Use the first argument as a name
            String name = args[0];
            System.out.println("Hello, " + name + "!");
        } else {
            // Default greeting if no arguments were provided
            System.out.println("Hello, World!");
            System.out.println("Tip: You can provide your name as an argument to get a personalized greeting.");
        }
    }
}
