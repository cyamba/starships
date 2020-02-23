package com.yambacode.swapi.service;

import com.yambacode.swapi.model.Starship;
import com.yambacode.swapi.repository.StarshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StarshipService {

    static final String COST_IN_CREDITS_FIELD = "costInCredits";
    public static final int NUMBER_OF_STARSHIPS = 7;

    private StarshipRepository starshipRepository;

    @Autowired
    public StarshipService(StarshipRepository starshipRepository) {
        this.starshipRepository = starshipRepository;
    }

    public List<Starship> listAll() {
        return starshipRepository.findAll();
    }

    public Starship getStarshipById(String id) {
        return starshipRepository.findById(id).orElseGet(null);
    }

    public List<Starship> getStarshipsByCost(Integer count) {
        if (count == null) {
            count = NUMBER_OF_STARSHIPS;
        }
        return starshipRepository
                .findAll()
                .stream()
                .filter(starship -> !starship.getCostInCredits().toString().equalsIgnoreCase("unknown"))
                .sorted(Comparator
                        .comparingLong(starship -> Long.parseLong(((Starship) starship).getCostInCredits())).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    public Starship save(@Valid Starship starship) {
        if (starshipRepository.exists(Example.of(starship))) {
            return starshipRepository.save(starship);
        }
        return null;
    }

}
