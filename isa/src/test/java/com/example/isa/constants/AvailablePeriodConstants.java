package com.example.isa.constants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.example.isa.model.BoatAvailablePeriod;
import com.example.isa.model.Boat;

public class AvailablePeriodConstants {
	
	private AvailablePeriodConstants() {}
	
	public static final Boat BOAT = new Boat("Milicija", "Promo milicije");
	
	private static final BoatAvailablePeriod a1 = new BoatAvailablePeriod(new GregorianCalendar(2022, Calendar.JANUARY, 1).getTime(),new GregorianCalendar(2022, Calendar.JANUARY, 10).getTime(),BOAT);
	private static final BoatAvailablePeriod a2 = new BoatAvailablePeriod(new GregorianCalendar(2022, Calendar.JANUARY, 20).getTime(),new GregorianCalendar(2022, Calendar.JANUARY, 28).getTime(),BOAT);
	private static final BoatAvailablePeriod a3 = new BoatAvailablePeriod(new GregorianCalendar(2022, Calendar.MARCH, 1).getTime(),new GregorianCalendar(2022, Calendar.MARCH, 16).getTime(),BOAT);
	private static final BoatAvailablePeriod a4 = new BoatAvailablePeriod(new GregorianCalendar(2022, Calendar.JUNE, 1).getTime(),new GregorianCalendar(2022, Calendar.JUNE, 21).getTime(),BOAT);


	public static final List<BoatAvailablePeriod> BOAT_AVAILABLE_PERIODS = new ArrayList<BoatAvailablePeriod>() {{
        add(a1);
        add(a2);
        add(a3);
        add(a4);
	}};

	public static final BoatAvailablePeriod TEST_PERIOD_VALID = new BoatAvailablePeriod(new GregorianCalendar(2022, Calendar.JUNE, 2).getTime(),new GregorianCalendar(2022, Calendar.JUNE, 18).getTime(),BOAT);
	public static final BoatAvailablePeriod TEST_PERIOD_NOT_VALID = new BoatAvailablePeriod(new GregorianCalendar(2022, Calendar.DECEMBER, 2).getTime(),new GregorianCalendar(2022, Calendar.DECEMBER, 18).getTime(),BOAT);

}
