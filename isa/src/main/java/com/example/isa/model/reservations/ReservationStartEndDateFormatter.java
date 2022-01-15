package com.example.isa.model.reservations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.example.isa.dto.ReservationDTO;


public class ReservationStartEndDateFormatter  {
	
	private ReservationDTO reservation;
	public Date startDate;
	public Date endDate;
	
	public ReservationStartEndDateFormatter(ReservationDTO reservation) throws ParseException {
		this.reservation = reservation;
		getStartDate();
		getEndDate();
	}
	
	public void getStartDate()  throws ParseException {		
		
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		this.startDate =  formatter.parse(reservation.getStartDate() + " " +reservation.getStartTime());		
	}
	
	public void getEndDate() {
		
		Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DAY_OF_MONTH, reservation.getNumberOfDays());
        cal.add(Calendar.HOUR, reservation.getNumberOfHours()); 
        this.endDate = cal.getTime();		
	}
	
}
