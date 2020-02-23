package com.yambacode.swapi.service;

import com.yambacode.swapi.model.Starship;
import com.yambacode.swapi.repository.StarshipRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StarshipServiceTest {

    private StarshipService starshipService;
    private StarshipRepository repository;

    @Before
    public void setup() {
        repository = Mockito.mock(StarshipRepository.class);
        starshipService = new StarshipService(repository);
    }

    @Test
    public void testGetStarshipsOrderedByCost() {

        List<Starship> starships = createStarships();

        Mockito.when(repository.findAll()).thenReturn(starships);

        List<Starship> starshipsByCost = starshipService.getStarshipsByCost(5);

        assertNotNull(starshipsByCost);

        assertEquals(5, starshipsByCost.size());

        assertEquals("7000", starshipsByCost.get(0).getCostInCredits());
        assertEquals("5", starshipsByCost.get(0).getStarshipId());

        assertEquals("6000", starshipsByCost.get(1).getCostInCredits());
        assertEquals("3", starshipsByCost.get(1).getStarshipId());

        assertEquals("5000", starshipsByCost.get(2).getCostInCredits());
        assertEquals("4", starshipsByCost.get(2).getStarshipId());


        assertEquals("4000", starshipsByCost.get(3).getCostInCredits());
        assertEquals("6", starshipsByCost.get(3).getStarshipId());


        assertEquals("3000", starshipsByCost.get(4).getCostInCredits());
        assertEquals("1", starshipsByCost.get(4).getStarshipId());

    }

    @Test
    public void testWithDefault_7_starships() {

        List<Starship> starships = createStarships();

        Mockito.when(repository.findAll()).thenReturn(starships);

        List<Starship> starshipsByCost = starshipService.getStarshipsByCost(null);

        assertNotNull(starshipsByCost);
        assertEquals(7, starshipsByCost.size());


        assertEquals("7000", starshipsByCost.get(0).getCostInCredits());
        assertEquals("5", starshipsByCost.get(0).getStarshipId());

        assertEquals("6000", starshipsByCost.get(1).getCostInCredits());
        assertEquals("3", starshipsByCost.get(1).getStarshipId());

        assertEquals("5000", starshipsByCost.get(2).getCostInCredits());
        assertEquals("4", starshipsByCost.get(2).getStarshipId());


        assertEquals("4000", starshipsByCost.get(3).getCostInCredits());
        assertEquals("6", starshipsByCost.get(3).getStarshipId());


        assertEquals("3000", starshipsByCost.get(4).getCostInCredits());
        assertEquals("1", starshipsByCost.get(4).getStarshipId());

        assertEquals("2000", starshipsByCost.get(5).getCostInCredits());
        assertEquals("2", starshipsByCost.get(5).getStarshipId());

        assertEquals("1000", starshipsByCost.get(6).getCostInCredits());
        assertEquals("0", starshipsByCost.get(6).getStarshipId());

    }

    private List<Starship> createStarships() {
        return Arrays.asList(
                Starship.of("0", "1000"),
                Starship.of("1", "3000"),
                Starship.of("2", "2000"),
                Starship.of("3", "6000"),
                Starship.of("4", "5000"),
                Starship.of("5", "7000"),
                Starship.of("6", "4000"),
                Starship.of("7", "800"),
                Starship.of("8", "400"),
                Starship.of("9", "555"));
    }

}