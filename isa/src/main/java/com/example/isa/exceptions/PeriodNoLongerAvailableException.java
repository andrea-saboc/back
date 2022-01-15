package com.example.isa.exceptions;

public class PeriodNoLongerAvailableException extends Exception{
	
	public PeriodNoLongerAvailableException() {
        super("This time period is no longer available!");
    }
}
