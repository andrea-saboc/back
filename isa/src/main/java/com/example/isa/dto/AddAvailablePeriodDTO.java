package com.example.isa.dto;

import java.util.Date;

public class AddAvailablePeriodDTO {
    public Date startTime;
    public Date endTime;
    public Long boatId;

    public  AddAvailablePeriodDTO(){}

    public AddAvailablePeriodDTO(Date startTime, Date endTime, Long boatId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.boatId = boatId;
    }
}
