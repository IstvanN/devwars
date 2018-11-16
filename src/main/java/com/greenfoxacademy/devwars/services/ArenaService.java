package com.greenfoxacademy.devwars.services;

import com.greenfoxacademy.devwars.models.characterlogic.Character;
import com.greenfoxacademy.devwars.models.gamelogic.Arena;
import com.greenfoxacademy.devwars.repositories.ArenaRepository;
import com.greenfoxacademy.devwars.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArenaService {

    private ArenaRepository arenaRepository;
    private CharacterRepository characterRepository;

    @Autowired
    public ArenaService(ArenaRepository arenaRepository, CharacterRepository characterRepository) {
        this.arenaRepository = arenaRepository;
        this.characterRepository = characterRepository;
    }

    /**
     *
     * @param characters: the list of characters selected by the players for the new game
     * @return the id of the created Arena
     */
    public Long createNewArenaFromCharacters(List<Character> characters) {
        Arena newArena = Arena.fromCharacters(characters);
        Arena savedArena = arenaRepository.save(newArena);
        return savedArena.getId();
    }

    public Long createNewArenaFromCharacterIds(List<Long> characterIds) {
        List<Character> characters = new ArrayList<>();
        Optional<Character> character;
        for (Long id : characterIds) {
            character = characterRepository.findById(id);
            if (character.isPresent())
                characters.add(character.get());
            else
                throw new IllegalArgumentException("Character with id not found: " + id);
        }

        return createNewArenaFromCharacters(characters);
    }

}
