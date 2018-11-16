package com.greenfoxacademy.devwars.services;

import com.greenfoxacademy.devwars.models.characterlogic.Character;
import com.greenfoxacademy.devwars.models.characterlogic.OS;
import com.greenfoxacademy.devwars.repositories.CharacterRepository;
import com.greenfoxacademy.devwars.repositories.OSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;
    @Autowired
    OSRepository osRepository;

    public void save(Character character) {
        characterRepository.save(character);
    }

    public List<OS> getOSList() {
        return osRepository.findAll();
    }
}
