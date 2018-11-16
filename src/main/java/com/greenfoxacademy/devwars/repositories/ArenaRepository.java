package com.greenfoxacademy.devwars.repositories;

import com.greenfoxacademy.devwars.models.gamelogic.Arena;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArenaRepository extends CrudRepository<Arena, Long> {
}
