package com.greenfoxacademy.devwars.controllers;

import com.greenfoxacademy.devwars.models.characterlogic.Character;
import com.greenfoxacademy.devwars.models.characterlogic.CharacterCompetence;
import com.greenfoxacademy.devwars.models.characterlogic.Competence;
import com.greenfoxacademy.devwars.models.characterlogic.League;
import com.greenfoxacademy.devwars.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CharacterController {
    Character character = new Character();

    @Autowired
    CharacterService characterService;

    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("newcharacter", character);
        model.addAttribute("league", character.getLeague());
        model.addAttribute("competence1");
        model.addAttribute("competence2");
        return "create";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute Character character,
                             @ModelAttribute League league,
                             @ModelAttribute String competence1,
                             @ModelAttribute String competence2) {
        character.setLeague(league);
        characterService.save(character);
        return "redirect:/";
    }
}
