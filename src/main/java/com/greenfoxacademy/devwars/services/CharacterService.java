package com.greenfoxacademy.devwars.services;

import com.greenfoxacademy.devwars.models.characterlogic.*;
import com.greenfoxacademy.devwars.models.characterlogic.Character;
import com.greenfoxacademy.devwars.repositories.CharacterRepository;
import com.greenfoxacademy.devwars.repositories.CompetenceRepository;
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
    @Autowired
    CompetenceRepository competenceRepository;

    public void save(Character character) {
        characterRepository.save(character);
    }

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    public List<OS> getOSList() {
        return osRepository.findAll();
    }

    public List<Competence> getAllCompetences() {
        return competenceRepository.findAll();
    }

    public List<Competence> getAllLanguages() {
      return competenceRepository.findAllByType(CompetenceType.LANGUAGE);
    }

    public List<Competence> getAllTechnologies() {
      return competenceRepository.findAllByType(CompetenceType.TECHNOLOGY);
    }

    public OS getOSById(long id) {
      return osRepository.findById(id).orElse(null);
    }

}
