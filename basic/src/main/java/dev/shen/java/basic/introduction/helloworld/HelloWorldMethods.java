package dev.shen.java.basic.introduction.helloworld;

/**
 * A Hello World example that demonstrates methods.
 * This class shows:
 * - Creating and calling methods
 * - Method parameters and return values
 * - String formatting
 */
public class HelloWorldMethods {

    /**
     * Main method that calls other methods.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // Simple method call with no arguments
        printSimpleGreeting();

        // Method call with an argument
        String name = args.length > 0 ? args[0] : "World";
        printPersonalizedGreeting(name);

        // Method call that returns a value
        String greeting = createGreeting(name);
        System.out.println(greeting);

        // Method call with multiple arguments
        if (args.length > 1) {
            printGreetingWithLanguage(name, args[1]);
        } else {
            printGreetingWithLanguage(name, "en");
        }
    }

    /**
     * Prints a simple greeting without parameters.
     */
    private static void printSimpleGreeting() {
        System.out.println("Hello, World!");
    }

    /**
     * Prints a personalized greeting using a parameter.
     *
     * @param name The name to include in the greeting
     */
    private static void printPersonalizedGreeting(String name) {
        System.out.println("Hello, " + name + "!");
    }

    /**
     * Creates a greeting string instead of printing it.
     * Demonstrates returning values from methods.
     *
     * @param name The name to include in the greeting
     * @return The formatted greeting string
     */
    private static String createGreeting(String name) {
        return String.format("Greetings, %s!", name);
    }

    /**
     * Demonstrates a method with multiple parameters.
     *
     * @param name The name to greet
     * @param language The language code ("en", "es", "fr")
     */
    private static void printGreetingWithLanguage(String name, String language) {
        String greeting;

        // Switch based on language code
        switch (language.toLowerCase()) {
            case "es" -> greeting = "¡Hola, " + name + "!";
            case "fr" -> greeting = "Bonjour, " + name + "!";
            default -> greeting = "Hello, " + name + "!";
        }

        System.out.println(greeting);
    }
}
