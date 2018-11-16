package com.greenfoxacademy.devwars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CharacterController {

  @GetMapping("/")
  public String showWelcome() {
    return "welcome";
  }

  @GetMapping("/create")
  public String getCreate(){
    return "create";
  }

  @PostMapping("/create")
  public String postCreate(){
    return "redirect:/";
  }
}
