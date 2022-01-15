package com.example.isa.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.isa.constants.AvailablePeriodConstants;
import com.example.isa.model.Boat;
import com.example.isa.repository.BoatAvailablePeriodRepository;
import com.example.isa.repository.BoatRepository;
import com.example.isa.service.reservations.BoatReservationSuggestionService;




@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationSuggestionServiceTest {

	@Mock
	BoatAvailablePeriodRepository periodsRepository;
	
	@Mock
	BoatRepository boatRepository;
	
	@InjectMocks
	private BoatReservationSuggestionService service;
	
	@Test
	public void CheckDateRangeValid() {
				
		when(periodsRepository.findAll()).thenReturn(AvailablePeriodConstants.BOAT_AVAILABLE_PERIODS);
		when(boatRepository.findAll()).thenReturn(Arrays.asList(AvailablePeriodConstants.BOAT));
		
		List<Boat> boats = service.getAvailableBoatsBetweenDates(AvailablePeriodConstants.TEST_PERIOD_VALID.getStartDate(), AvailablePeriodConstants.TEST_PERIOD_VALID.getEndDate());
		
		assertTrue(boats.iterator().hasNext());
	}
	
	@Test
	public void CheckDateRangeNotValid() {
				
		when(periodsRepository.findAll()).thenReturn(AvailablePeriodConstants.BOAT_AVAILABLE_PERIODS);
		when(boatRepository.findAll()).thenReturn(Arrays.asList(AvailablePeriodConstants.BOAT));
		
		List<Boat> boats = service.getAvailableBoatsBetweenDates(AvailablePeriodConstants.TEST_PERIOD_NOT_VALID.getStartDate(), AvailablePeriodConstants.TEST_PERIOD_NOT_VALID.getEndDate());
		
		assertTrue(!boats.iterator().hasNext());
	}
	
}
