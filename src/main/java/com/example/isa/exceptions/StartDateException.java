package com.example.isa.exceptions;

public class StartDateException  extends Exception {
    public StartDateException() {
        super("This time period is no longer available!");
    }
}
