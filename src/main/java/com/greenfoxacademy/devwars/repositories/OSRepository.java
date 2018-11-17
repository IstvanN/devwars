package com.greenfoxacademy.devwars.repositories;

import com.greenfoxacademy.devwars.models.characterlogic.OS;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OSRepository extends CrudRepository<OS, Long> {
    List<OS> findAll();
}
