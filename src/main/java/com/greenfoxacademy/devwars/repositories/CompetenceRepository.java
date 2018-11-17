package com.greenfoxacademy.devwars.repositories;

import com.greenfoxacademy.devwars.models.characterlogic.Competence;
import com.greenfoxacademy.devwars.models.characterlogic.CompetenceType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompetenceRepository extends CrudRepository<Competence, Long> {

  List<Competence> findAll();
  List<Competence> findAllByType(CompetenceType competenceType);
}
