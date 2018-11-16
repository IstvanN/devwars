package com.greenfoxacademy.devwars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LobbyController {

  @GetMapping("/lobby")
  public String showLobby() {
    return "lobby";
  }
}
