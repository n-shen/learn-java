package dev.shen.java.basic.classes.interfaces;

// Usage with lambda expression (alternative implementation)
public class ValidationExample {
    public static void main(String[] args) {
        // Class implementation
        Validator emailValidator = new EmailValidator();

        // Lambda implementation
        Validator passwordValidator = (input) -> input != null && input.length() >= 8;

        String email = "test@example.com";
        String password = "pass123";

        System.out.println("Email valid: " + emailValidator.validate(email));
        System.out.println("Password valid: " + passwordValidator.validate(password));
    }
}
