package com.greenfoxacademy.devwars.controllers;

import com.greenfoxacademy.devwars.models.gamelogic.Arena;
import com.greenfoxacademy.devwars.services.ArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("{id}")
  public String showArena(
          @PathVariable("id") Long id,
          Model model
          )
  {
    Arena arena = arenaService.getArena(id);
    model.addAttribute("arena", arena);
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

  @PostMapping("{id}")
  public String submitExecuteEndTurn(
                        @PathVariable("id") Long id,
                        @ModelAttribute("selectedAction") String selectedAction,
                        Model model)
  {
        arenaService.executeEndTurn(id, selectedAction);
        return "redirect:" + CONTROLLER_ROOT + id;
  }

  @PostMapping("{id}/delete")
    public String deleteArena(@PathVariable("id") Long id) {
      arenaService.deleteArena(id);
      return "redirect:/";
  }
}
