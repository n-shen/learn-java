package dev.shen.java.basic.classes.interfaces;

public class EmailValidator implements Validator{
    public boolean validate(String input) {
        return input != null && input.contains("@") && input.contains(".");
    }
}

