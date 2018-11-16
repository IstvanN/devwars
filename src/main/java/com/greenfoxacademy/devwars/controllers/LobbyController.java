package com.greenfoxacademy.devwars.controllers;

import com.greenfoxacademy.devwars.models.characterlogic.Character;
import com.greenfoxacademy.devwars.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LobbyController {

  @Autowired
  CharacterService characterService;


  @GetMapping("/lobby")
  public String showLobby(Model model) {
    List<Character> characters = characterService.getAllCharacters();
    model.addAttribute("characters", characters);
    return "lobby";
  }
}
