package com.kaliszewski.narutowiki.api.repository;

import com.kaliszewski.narutowiki.api.models.Shinobi;
import org.springframework.data.repository.CrudRepository;

public interface CharacterRepository extends CrudRepository<Shinobi, Long> {


}
