package com.greenfoxacademy.devwars.controllers;

import com.greenfoxacademy.devwars.services.ArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = ArenaController.CONTROLLER_ROOT)
public class ArenaController {
  public static final String CONTROLLER_ROOT = "/arena/";

  private ArenaService arenaService;

  @Autowired
  public ArenaController(ArenaService arenaService) {
    this.arenaService = arenaService;
  }

  @GetMapping
  public String showArena(){
    return "arena";
  }

  @PostMapping
  public String createNewFromCharacterIds(
          @ModelAttribute("characterId1") Long characterId1,
          @ModelAttribute("characterId2") Long characterId2
          )
  {
      List<Long> characterIds = Arrays.asList(characterId1, characterId2);
      Long newArenaId = arenaService.createNewArenaFromCharacterIds(characterIds);
      return "redirect:" + CONTROLLER_ROOT + newArenaId;
  }
}
