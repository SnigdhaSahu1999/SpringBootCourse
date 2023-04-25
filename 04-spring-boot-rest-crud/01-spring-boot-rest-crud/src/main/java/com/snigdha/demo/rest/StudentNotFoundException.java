package com.snigdha.demo.rest;

public class StudentNotFoundException extends RuntimeException{

    //thie constructor is required as of now
    public StudentNotFoundException(String message) {
        super(message);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
