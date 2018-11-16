package com.greenfoxacademy.devwars.repositories;

import com.greenfoxacademy.devwars.models.gamelogic.Action;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends CrudRepository<Action, Long> {
}
