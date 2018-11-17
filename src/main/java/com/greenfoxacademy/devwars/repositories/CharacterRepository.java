package com.greenfoxacademy.devwars.repositories;

import com.greenfoxacademy.devwars.models.characterlogic.Character;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharacterRepository extends CrudRepository<Character, Long> {
  List<Character> findAll();
}
