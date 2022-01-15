package com.example.isa.service;

import com.example.isa.model.Boat;
import com.example.isa.model.reservations.AdditionalService;
import com.example.isa.repository.AdditionalServiceRepository;
import com.example.isa.repository.BoatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalServiceService {
    @Autowired
    private BoatRepository boatRepository;
    @Autowired
    private AdditionalServiceRepository additionalServiceRepository;

    public AdditionalServiceService(BoatRepository br, AdditionalServiceRepository asr){
        boatRepository = br;
        additionalServiceRepository = asr;
    }

    public List<AdditionalService> getByBoatid(Long id) {
        Boat boat = boatRepository.findById(id).get();
        List<AdditionalService> additionalServices = additionalServiceRepository.findAllByBoat(boat);
        return additionalServices;
    }
}
