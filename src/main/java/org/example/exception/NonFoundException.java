package org.example.exception;

/**
 * Возникает в случае ненахождения сущности.
 */
public class NonFoundException extends Exception {
    public NonFoundException(String message) {
        super(message);
    }
}
