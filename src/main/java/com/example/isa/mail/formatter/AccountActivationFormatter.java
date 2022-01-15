package com.example.isa.mail.formatter;


public class AccountActivationFormatter {
	
    public String getText(String link) {
        return " Click on this activation code to verify your registration  " + link;
    }

    public String getSubject() {
        return "Welcome to Fishing Fish!";
    }
}
