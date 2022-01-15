package com.example.isa.dto;

import com.example.isa.model.Boat;
import com.example.isa.model.reservations.BoatDiscountReservation;

import java.util.List;

public class AllBoatDiscountReservationsDTO {
    public List<BoatDiscountReservation> reservedReservations;
    public List<BoatDiscountReservation> freeReservations;

    public AllBoatDiscountReservationsDTO(){}
}
