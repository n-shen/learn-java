# Java Inheritance Tutorial: `extends` vs `implements`

## Table of Contents
1. [Introduction](#introduction)
2. [Using `extends`](#using-extends)
   - [When to Use `extends`](#when-to-use-extends)
   - [Examples of `extends`](#examples-of-extends)
3. [Using `implements`](#using-implements)
   - [When to Use `implements`](#when-to-use-implements)
   - [Examples of `implements`](#examples-of-implements)
4. [Multiple Inheritance in Java](#multiple-inheritance-in-java)
5. [Best Practices](#best-practices)
6. [Common Patterns](#common-patterns)

## Introduction

Java supports two primary mechanisms for code reuse and establishing relationships between classes:

- **`extends`** - Used for class inheritance (class to class relationship)
- **`implements`** - Used for interface implementation (class to interface relationship)

Understanding when to use each is crucial for good object-oriented design.

## Using `extends`

### When to Use `extends`

Use `extends` when:

- You want to create an "is-a" relationship between classes
- You need to inherit and reuse implementation code from a parent class
- You want to extend or override behavior from a parent class
- You're modeling a hierarchical relationship

### Examples of `extends`

#### Basic Inheritance

```java
package dev.shen.java.basic.inheritance;

// Parent/Base class
public class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    
    public Vehicle(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }
    
    public void start() {
        System.out.println("Vehicle starting...");
    }
    
    public void stop() {
        System.out.println("Vehicle stopping...");
    }
    
    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}

// Child/Derived class
public class Car extends Vehicle {
    private int numberOfDoors;
    
    public Car(String make, String model, int year, int numberOfDoors) {
        // Call parent constructor
        super(make, model, year);
        this.numberOfDoors = numberOfDoors;
    }
    
    // Override parent method
    @Override
    public void start() {
        System.out.println("Car engine starting with key...");
    }
    
    // Add new functionality
    public void honk() {
        System.out.println("Beep beep!");
    }
}
```

#### Method Overriding

```java
package dev.shen.java.basic.inheritance;

// Parent class with a method we'll override
public class Shape {
    public double calculateArea() {
        return 0; // Default implementation
    }
}

// Child class overriding the calculateArea method
public class Circle extends Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// Another child class with different implementation
public class Rectangle extends Shape {
    private double width;
    private double height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public double calculateArea() {
        return width * height;
    }
}
```

#### Abstract Classes

```java
package dev.shen.java.basic.inheritance;

// Abstract parent class
public abstract class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    // Concrete method
    public void sleep() {
        System.out.println(name + " is sleeping...");
    }
    
    // Abstract method (must be implemented by subclasses)
    public abstract void makeSound();
}

// Concrete child class
public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }
    
    // Add specific method
    public void fetch() {
        System.out.println(name + " is fetching the ball!");
    }
}

// Another concrete child class
public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }
    
    // Add specific method
    public void scratch() {
        System.out.println(name + " is scratching!");
    }
}
```

## Using `implements`

### When to Use `implements`

Use `implements` when:

- You want to specify a contract that a class must fulfill
- You need to define behavior without implementation
- You want multiple classes to share common method signatures
- You're designing for polymorphism and flexibility
- You want to achieve a form of multiple inheritance

### Examples of `implements`

#### Basic Interface Implementation

```java
package dev.shen.java.basic.interfaces;

// Define an interface
public interface Drawable {
    void draw(); // Abstract method (no implementation)
    
    // Default method (with implementation, added in Java 8)
    default void displayInfo() {
        System.out.println("This is a drawable object");
    }
}

// Class implementing the interface
public class Circle implements Drawable {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // Must implement the abstract method
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
}

// Another class implementing the same interface
public class Rectangle implements Drawable {
    private double width;
    private double height;
    
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
}
```

#### Multiple Interface Implementation

```java
package dev.shen.java.basic.interfaces;

// First interface
public interface Movable {
    void move(double x, double y);
}

// Second interface
public interface Resizable {
    void resize(double factor);
}

// Class implementing multiple interfaces
public class GameCharacter implements Movable, Resizable {
    private double posX;
    private double posY;
    private double size;
    
    public GameCharacter(double posX, double posY, double size) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
    }
    
    @Override
    public void move(double x, double y) {
        this.posX += x;
        this.posY += y;
        System.out.println("Character moved to position (" + posX + "," + posY + ")");
    }
    
    @Override
    public void resize(double factor) {
        this.size *= factor;
        System.out.println("Character resized to " + size);
    }
}
```

#### Functional Interfaces (Java 8+)

```java
package dev.shen.java.basic.interfaces;

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

// Implementation using a class
public class EmailValidator implements Validator {
    @Override
    public boolean validate(String input) {
        return input != null && input.contains("@") && input.contains(".");
    }
}

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
```

## Multiple Inheritance in Java

Java doesn't support multiple inheritance of classes (can't extend more than one class), but it does support multiple inheritance of interfaces.

```java
package dev.shen.java.basic.inheritance;

// Base class
public class Employee {
    protected String name;
    protected int id;
    
    // Methods and constructors
    // ...
}

// First interface
public interface Billable {
    double calculateBillableAmount();
}

// Second interface
public interface Reportable {
    void generateReport();
}

// Class using both inheritance and multiple interfaces
public class Consultant extends Employee implements Billable, Reportable {
    private double hourlyRate;
    private int hoursWorked;
    
    // Constructor, getters, setters
    // ...
    
    @Override
    public double calculateBillableAmount() {
        return hourlyRate * hoursWorked;
    }
    
    @Override
    public void generateReport() {
        System.out.println("Generating consultant report for " + name);
        // Report generation logic
    }
}
```

## Best Practices

1. **Use `extends` when**:
   - There's a true "is-a" relationship
   - You need to reuse implementation code
   - You want to maintain encapsulation from the parent class

2. **Use `implements` when**:
   - You want to define a contract without implementation details
   - You need a class to fulfill multiple roles
   - You're designing for future flexibility
   - You want to enable polymorphic behavior across unrelated classes

3. **Design Principles**:
   - Favor composition over inheritance when possible
   - Follow the Interface Segregation Principle (small, specific interfaces)
   - Avoid deep inheritance hierarchies (prefer shallow and wide)
   - Use abstract classes for partial implementations
   - Use interfaces for defining contracts

## Common Patterns

### Template Method Pattern (using `extends`)

```java
package dev.shen.java.basic.patterns;

// Abstract template class
public abstract class DocumentProcessor {
    // Template method
    public final void processDocument() {
        openDocument();
        extractContent();
        analyzeContent();
        generateReport();
        closeDocument();
    }
    
    // Common implementation
    protected void openDocument() {
        System.out.println("Opening document...");
    }
    
    protected void closeDocument() {
        System.out.println("Closing document...");
    }
    
    // Methods to be implemented by subclasses
    protected abstract void extractContent();
    protected abstract void analyzeContent();
    protected abstract void generateReport();
}

// Concrete implementation
public class PDFProcessor extends DocumentProcessor {
    @Override
    protected void extractContent() {
        System.out.println("Extracting content from PDF...");
    }
    
    @Override
    protected void analyzeContent() {
        System.out.println("Analyzing PDF content...");
    }
    
    @Override
    protected void generateReport() {
        System.out.println("Generating report from PDF analysis...");
    }
}
```

### Strategy Pattern (using `implements`)

```java
package dev.shen.java.basic.patterns;

// Strategy interface
public interface PaymentStrategy {
    void processPayment(double amount);
}

// Concrete strategies
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;
    
    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + 
                         " with card " + cardNumber);
    }
}

public class PayPalPayment implements PaymentStrategy {
    private String email;
    
    public PayPalPayment(String email) {
        this.email = email;
    }
    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount + 
                         " to account " + email);
    }
}

// Context class using the strategy
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    
    public void checkout(double totalAmount) {
        paymentStrategy.processPayment(totalAmount);
        System.out.println("Checkout completed!");
    }
}
```

---

By understanding when to use `extends` versus `implements`, you can design more flexible, maintainable, and robust Java applications.
