package com.greenfoxacademy.devwars.controllers;

import com.greenfoxacademy.devwars.models.characterlogic.Character;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class LobbyController {


  @GetMapping("/lobby")
  public String showLobby(Model model) {
    List<Character> characters =
    return "lobby";
  }

  @PostMapping("/getCharacters")
  public String getCharacters(@PathVariable("characterId") long characterId) {

    return "redirect:/arena";
  }
}
