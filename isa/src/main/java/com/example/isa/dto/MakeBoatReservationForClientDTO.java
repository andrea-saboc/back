package com.example.isa.dto;

import com.example.isa.model.reservations.AdditionalService;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class MakeBoatReservationForClientDTO {
    public String email;
    public Set<AdditionalService> additionalServiceSet;
    public Date startDate;
    public Date endDate;
    public Long boatId;
    public int numberOfGuests;

    public MakeBoatReservationForClientDTO(){}

    @Override
    public String toString() {
        return "MakeBoatReservationForClientDTO{" +
                "email='" + email + '\'' +
                ", additionalServiceSet=" + additionalServiceSet +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", boatId=" + boatId +
                ", numberOfGuests=" + numberOfGuests +
                '}';
    }
}
