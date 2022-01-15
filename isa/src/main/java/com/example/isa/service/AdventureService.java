package com.example.isa.service;

import com.example.isa.model.Adventure;
import com.example.isa.repository.AdventureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdventureService {
    @Autowired
    private AdventureRepository adventureRepository;
    @Autowired
    public AdventureService(AdventureRepository ar) {
        this.adventureRepository = ar;
    }

    public void creatAdventure(){
        Adventure a = new Adventure("Advantura", "Rumenacka 12", "skks", (float) 0.11);
        adventureRepository.save(a);
    }
}
