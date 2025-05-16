package dev.shen.java.basic.introduction.helloworld;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Simple test class for HelloWorld examples.
 */
public class HelloWorldTest {

    @Test
    public void testHelloWorld() {
        // Capture System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        // Run the main method
        HelloWorld.main(new String[]{});

        // Reset System.out
        System.setOut(originalOut);

        // Verify output contains "Hello, World!"
        assertTrue(outContent.toString().contains("Hello, World!"));
    }
}
