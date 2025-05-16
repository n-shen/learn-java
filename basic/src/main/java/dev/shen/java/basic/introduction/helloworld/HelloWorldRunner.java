package dev.shen.java.basic.introduction.helloworld;

import dev.shen.java.basic.common.Runner;

/**
 * Runner class that executes all Hello World examples in sequence.
 * This demonstrates using the Runner utility to execute multiple examples.
 */
public class HelloWorldRunner {

    /**
     * Main method that runs all Hello World examples.
     *
     * @param args Command line arguments to pass to the examples
     */
    public static void main(String[] args) {
        System.out.println("=== Running Hello World Examples ===");

        // Run all examples in sequence
        Runner.runExamples(args,
                "dev.shen.java.basic.introduction.helloworld.HelloWorld",
                "dev.shen.java.basic.introduction.helloworld.HelloWorldArgs",
                "dev.shen.java.basic.introduction.helloworld.HelloWorldMethods"
        );

        System.out.println("=== All Hello World Examples Complete ===");
    }
}
