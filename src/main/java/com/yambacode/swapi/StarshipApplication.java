package com.yambacode.swapi;


import com.yambacode.swapi.model.Starship;
import com.yambacode.swapi.repository.StarshipLoader;
import com.yambacode.swapi.repository.StarshipRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class StarshipApplication implements CommandLineRunner {

    private static Logger LOGGER = LoggerFactory.getLogger(StarshipApplication.class);

    @Autowired
    StarshipRepository repository;

    @Autowired
    StarshipLoader starshipLoader;

    public static void main(String[] args) {

        SpringApplication.run(StarshipApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        LOGGER.info("*************** Welcome to Swapi Starships! May the force  be with you! ***************");

        List<Starship> all = repository.findAll();
        LOGGER.info("Find starships : {}", all);

        LOGGER.info("Delete starships: {}", all);

        repository.deleteAll();

        List<Starship> starships = starshipLoader.loadStarships();
        repository.saveAll(starships);
        LOGGER.info("Populate starships : {}", starships);
    }


}
