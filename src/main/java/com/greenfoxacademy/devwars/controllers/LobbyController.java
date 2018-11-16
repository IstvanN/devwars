package com.greenfoxacademy.devwars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LobbyController {


  @GetMapping("/lobby")
  public String showLobby() {
    return "lobby";
  }

  @PostMapping("/getCharacters")
  public String getCharacters(@PathVariable("characterId") long characterId) {

    return "redirect:/arena";
  }
}
