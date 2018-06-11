package com.kaliszewski.narutowiki.api.repository;

import com.kaliszewski.narutowiki.api.models.Character;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CharacterRepository extends CrudRepository<Character,Long> {


}
