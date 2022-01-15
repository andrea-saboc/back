package com.example.isa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.dto.AdvertiserRegistrationDTO;
import com.example.isa.dto.ClientRegistrationDTO;
import com.example.isa.service.AdvertiserRegisterService;
import com.example.isa.service.ClientRegistrationService;

@RestController
@RequestMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegisterController {

    private final AdvertiserRegisterService advertiserRegisterService;
    private final ClientRegistrationService clientRegistrationService;

    @Autowired
    public RegisterController(AdvertiserRegisterService advertiserRegisterService, ClientRegistrationService clientRegistrationService ) {
        this.advertiserRegisterService = advertiserRegisterService;
        this.clientRegistrationService = clientRegistrationService;
    }
    /* try {
            this.registerPatientService.register(patientDTO, getSiteURL(request));
            return new ResponseEntity<>("/emailSent", HttpStatus.OK);
        } catch (BadUserInformationException e) {
            return new ResponseEntity<>(userExistsAlert, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(registrationFailedAlert, HttpStatus.INTERNAL_SERVER_ERROR);
        }*/

    @RequestMapping(value = "/advertiser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> register(@RequestBody AdvertiserRegistrationDTO advertiserData){
        System.out.println("Advertiser adding :"+advertiserData.toString());
        try {
            this.advertiserRegisterService.saveNewAdvertiser(advertiserData);
            System.out.println(advertiserData.toString());
            return new ResponseEntity<>("Successfull registration", HttpStatus.OK);
        } catch (Exception e){
            return  new ResponseEntity<>("Failed to register", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
	@RequestMapping(method = RequestMethod.POST, value = "/client",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE )
	@CrossOrigin(origins = "*")
    public ResponseEntity<String> registerPatient(HttpServletRequest request,@RequestBody ClientRegistrationDTO clientDto) {
    	
        
        if (this.clientRegistrationService.clientExists(clientDto.getEmail()))
            return new ResponseEntity<>("userExists", HttpStatus.BAD_REQUEST);
        
        try {
            this.clientRegistrationService.registerClient(clientDto,getSiteURL(request));
            return new ResponseEntity<>("emailSent", HttpStatus.OK);
        	}
        catch(Exception e) {        	
        		System.out.println(e);
        	}
        
    return new ResponseEntity<>("okei",HttpStatus.OK);
    }
	
	
    private String getSiteURL(HttpServletRequest request) {
        return request.getHeader("origin");
    }
}
