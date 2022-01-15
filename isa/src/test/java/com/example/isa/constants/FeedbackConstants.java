package com.example.isa.constants;

import com.example.isa.dto.ClientFeedbackDTO;
import com.example.isa.model.Boat;
import com.example.isa.model.ClientFeedback;

public class FeedbackConstants {
	
	private FeedbackConstants() {}
	
	public static final Boat BOAT = new Boat("Malicija", "Promo Malicije..");
	
	public static final ClientFeedback f1 = new ClientFeedback("Zafovoljan sam totalno",3,"igi@gmail.com");
	
	public static ClientFeedbackDTO FEEDBACK = new ClientFeedbackDTO("Content feedback-aa", 4, 0);

}
