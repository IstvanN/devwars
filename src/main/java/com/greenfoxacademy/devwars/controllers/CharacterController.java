package com.greenfoxacademy.devwars.controllers;

import com.greenfoxacademy.devwars.models.characterlogic.Character;
import com.greenfoxacademy.devwars.models.characterlogic.CharacterCompetence;
import com.greenfoxacademy.devwars.models.characterlogic.League;
import com.greenfoxacademy.devwars.models.characterlogic.OS;
import com.greenfoxacademy.devwars.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class CharacterController {

  @Autowired
  CharacterService characterService;

  @GetMapping("/")
  public String showWelcome() {
    return "welcome";
  }

  @GetMapping("/create")
  public String getCreate(Model model) {
    Character character = new Character();
    model.addAttribute("newcharacter", character);
    model.addAttribute("oslist", characterService.getOSList());
    model.addAttribute("newcompetences", new ArrayList<CharacterCompetence>());
    model.addAttribute("languages", characterService.getAllLanguages());
    model.addAttribute("technologies", characterService.getAllTechnologies());
    return "create";
  }

  @PostMapping("/create")
  public String postCreate(@ModelAttribute Character character, @RequestParam("osId") Long osId, @RequestParam("league") League league) {
    OS os = characterService.getOSById(osId);
    character.setOs(os);
    character.setLeague(league);
    characterService.save(character);
    return "redirect:/";
  }
}
