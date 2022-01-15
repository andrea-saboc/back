package com.example.isa.mail.formatter;

import java.text.Format;
import java.text.SimpleDateFormat;

import com.example.isa.model.reservations.MansionReservation;

public class MansionReservationConfirmationMailFormatter {
    public String getText(MansionReservation reservation) {
    	
		Format formatter = new SimpleDateFormat("dd.MM.yyyy, HH:mm");
    	String content = "";
    	content += " Start date " + formatter.format(reservation.getStartDate()) +".\n";
    	content += " End date " + formatter.format(reservation.getEndDate()) +".\n";
    	content += " Reservation price (additional services included): " + reservation.getTotalPrice() +" euros. \n";
        return content ;
    }

    public String getSubject(String name) {
        return "Your reservation for "+name+" is confirmed!";
    }
}
