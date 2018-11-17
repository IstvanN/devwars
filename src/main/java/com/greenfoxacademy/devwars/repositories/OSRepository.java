package com.greenfoxacademy.devwars.repositories;

import com.greenfoxacademy.devwars.models.characterlogic.OS;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OSRepository extends CrudRepository<OS, Long> {
  List<OS> findAll();
}
