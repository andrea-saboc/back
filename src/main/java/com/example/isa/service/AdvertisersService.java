package com.example.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.dto.AdvertisersDTO;
import com.example.isa.model.BoatOwner;
import com.example.isa.model.FishingInstructor;
import com.example.isa.model.MansionOwner;
import com.example.isa.repository.BoatOwnerRepository;
import com.example.isa.repository.FishingInstructorRepository;
import com.example.isa.repository.MansionOwnerRepository;
import com.example.isa.repository.UserRepository;


@Service
public class AdvertisersService {
	@Autowired
    private UserRepository userRepository;
	@Autowired
    private BoatOwnerRepository boatOwnerRepository;
	public List<BoatOwner> boats;
	@Autowired
    private MansionOwnerRepository mansionnOwnerRepository;
	public List<MansionOwner> mansionOwners;
	@Autowired
    private FishingInstructorRepository fishingInstructorRepository;
	public List<FishingInstructor> fishingInstructors;
	
	public AdvertisersService(MansionOwnerRepository mansionOwnerRepository, BoatOwnerRepository boatOwnerRepository,FishingInstructorRepository fishnigInstructorRepository) {
        this.mansionnOwnerRepository = mansionOwnerRepository;
        this.boatOwnerRepository = boatOwnerRepository;
        this.fishingInstructorRepository=fishnigInstructorRepository;
    }
	
    public List<BoatOwner> getAllBoatOwner()
    {
       return boatOwnerRepository.findAll();
    }
    public List<MansionOwner> getAllMansionOwner()
    {
       return mansionnOwnerRepository.findAll();
    }
    public List<FishingInstructor> getAllFishingInstructor()
    {
       return fishingInstructorRepository.findAll();
    }
    
    public List<AdvertisersDTO> getAllAdvertisers()
    {
    	List<AdvertisersDTO> advertisers=new ArrayList<AdvertisersDTO>();
    	boats=getAllBoatOwner();
    	mansionOwners=getAllMansionOwner();
    	fishingInstructors=getAllFishingInstructor();
    	for(final BoatOwner boat : boats)
    	{
    	  AdvertisersDTO advertiser = new AdvertisersDTO(boat.getEmail(),boat.getReason());
    	  advertisers.add(advertiser);
    	}
    	for(final MansionOwner mansionOwner : mansionOwners)
    	{
    	  AdvertisersDTO advertiser = new AdvertisersDTO(mansionOwner.getEmail(),mansionOwner.getReason());
    	  advertisers.add(advertiser);
    	}
    	for(final FishingInstructor fishing : fishingInstructors)
    	{
    	  AdvertisersDTO advertiser = new AdvertisersDTO(fishing.getEmail(),fishing.getReason());
    	  advertisers.add(advertiser);
    	}

    	return advertisers;
    	
    }
    
    
    

}
