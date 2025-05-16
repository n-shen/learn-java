# Hello World Tutorial

This tutorial introduces the most fundamental concepts in Java programming through simple "Hello World" examples.

## Examples Included

1. **HelloWorld.java** - The simplest possible Java program.
    - Basic class structure
    - Main method as entry point
    - Standard output
   
    ```bash
    # Using Maven:
    mvn exec:java -pl basic -Dexec.mainClass="dev.shen.java.basic.introduction.helloworld.HelloWorld"
        
    # Using Java directly:
    java -cp basic/target/classes dev.shen.java.basic.introduction.helloworld.HelloWorld
    ```

2. **HelloWorldArgs.java** - Working with command-line arguments.
    - Accessing arguments passed to the program
    - Basic conditional logic
    - String concatenation
    
    ```bash
   # with arguments
    mvn exec:java -pl basic -Dexec.mainClass="dev.shen.java.basic.introduction.helloworld.HelloWorldArgs" -Dexec.args="Alice"
    ```

3. **HelloWorldMethods.java** - Introduction to Java methods.
    - Method declaration and calling
    - Parameters and return values
    - Method overloading (same name, different parameters)
    - Conditional logic with switch statements
   
    ```bash
    # Format: [name] [language-code]
    # Language codes: en (English), es (Spanish), fr (French)
    mvn exec:java -pl basic -Dexec.mainClass="dev.shen.java.basic.introduction.helloworld.HelloWorldMethods" -Dexec.args="Alice es"
    ```

## Run all examples via Runner

```bash
# Format: [name] [language-code]
# Language codes: en (English), es (Spanish), fr (French)
mvn exec:java -pl basic -Dexec.mainClass="dev.shen.java.basic.introduction.helloworld.HelloWorldRunner" -Dexec.args="Alice es"
```
## Run testcases

```bash
mvn test -pl basic -Dtest=HelloWorldTest
```