package dev.shen.java.basic.common;

import java.lang.reflect.Method;

/**
 * Utility class for running examples within the tutorial.
 * This runner allows executing multiple example classes sequentially.
 */
public class Runner {

    /**
     * Runs a specific example class by its fully qualified name.
     *
     * @param className The fully qualified name of the class to run
     * @param args Command line arguments to pass to the main method
     */
    public static void runExample(String className, String... args) {
        try {
            System.out.println("\n----------------------------------------------------");
            System.out.println("Running example: " + className);
            System.out.println("----------------------------------------------------");

            // Load the class dynamically
            Class<?> clazz = Class.forName(className);

            // Find the main method
            Method mainMethod = clazz.getMethod("main", String[].class);

            // Invoke the main method
            mainMethod.invoke(null, (Object) args);

            System.out.println("----------------------------------------------------");
            System.out.println("Example complete: " + className);
            System.out.println("----------------------------------------------------\n");
        } catch (Exception e) {
            System.err.println("Error running example: " + className);
            e.printStackTrace();
        }
    }

    /**
     * Runs multiple example classes in sequence.
     *
     * @param args Command line arguments to pass to all examples
     * @param classNames The fully qualified names of classes to run
     */
    public static void runExamples(String[] args, String... classNames) {
        for (String className : classNames) {
            runExample(className, args);
        }
    }
}
