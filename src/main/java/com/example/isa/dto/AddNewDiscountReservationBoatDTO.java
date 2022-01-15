package com.example.isa.dto;

import com.example.isa.model.reservations.AdditionalService;

import java.util.Date;

public class AddNewDiscountReservationBoatDTO {
    public Long boatId;
    public Date startDate;
    public Date endDate;
    public int numberOfGuests;
    public double priceWithDiscount;

    public AddNewDiscountReservationBoatDTO(){}

}
