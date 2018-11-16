package com.greenfoxacademy.devwars.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArenaController {

  @GetMapping("/arena")
  public String arena(){
    return "arena";
  }
}
