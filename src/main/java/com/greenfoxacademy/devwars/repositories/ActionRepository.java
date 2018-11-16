package com.greenfoxacademy.devwars.repositories;

import com.greenfoxacademy.devwars.models.gamelogic.Action;
import org.springframework.data.repository.CrudRepository;

public interface ActionRepository extends CrudRepository<Action, Long> {
}
