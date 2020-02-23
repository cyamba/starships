package com.yambacode.swapi.repository;

import com.yambacode.swapi.model.Starship;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarshipRepository extends MongoRepository<Starship, String> {

}
