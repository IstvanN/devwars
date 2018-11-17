package com.greenfoxacademy.devwars.services;

import com.greenfoxacademy.devwars.models.characterlogic.Character;
import com.greenfoxacademy.devwars.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

  @Autowired
  CharacterRepository characterRepository;

  public List<Character> getAllCharacters() {
    return characterRepository.findAll();
  }

  public void save(Character character) {
    characterRepository.save(character);
  }
}
