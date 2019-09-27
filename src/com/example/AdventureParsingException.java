package com.example;

/**
 * A custom exception to hold any messages of any exceptions thrown, and what caused it.
 */
public class AdventureParsingException extends Exception {
    public AdventureParsingException(String message) {
        super(message);
    }
}
