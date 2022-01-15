package com.example.isa.controller;

import com.example.isa.model.Boat;
import com.example.isa.model.reservations.AdditionalService;
import com.example.isa.service.AdditionalServiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdditionalServiceController {
    @Autowired
    private AdditionalServiceService service;

    public AdditionalServiceController(AdditionalServiceService as){ this.service = as;}

    @RequestMapping(method = RequestMethod.GET, value = "/additionalServices",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getByBoatId(@RequestParam Long id) throws JsonProcessingException{
        List<AdditionalService> additionalServiceList = service.getByBoatid(id);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(additionalServiceList);
        System.out.println(jsonString);
        return new ResponseEntity<>(jsonString, HttpStatus.OK);

    }

}
