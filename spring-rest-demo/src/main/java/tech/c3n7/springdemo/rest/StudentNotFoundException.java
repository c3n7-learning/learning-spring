package tech.c3n7.springdemo.rest;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}
