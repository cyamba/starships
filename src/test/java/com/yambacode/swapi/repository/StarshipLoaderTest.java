package com.yambacode.swapi.repository;

import com.google.gson.GsonBuilder;
import com.yambacode.swapi.model.Starship;
import com.yambacode.swapi.model.StarshipData;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


import static org.junit.Assert.*;

public class StarshipLoaderTest {

    public static final String PATH_TO_STARSHIPS = "src/main/resources/starships.json";

    private StarshipLoader starshipLoader;

    private Gson gson;

    @Before
    public void setUp() throws Exception {

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        gson = gsonBuilder.create();

        starshipLoader = new StarshipLoader(PATH_TO_STARSHIPS);
    }


    @Test
    public void loadStarshipsFromJsonFile() throws FileNotFoundException {

        List<Starship> starships = starshipLoader.loadStarships();
        assertNotNull(starships);
        assertTrue(starships.size() > 0);
        System.out.println(starships);

    }


    @Test
    public void createWerlabsResultFromJson() throws FileNotFoundException {

        JsonReader reader = new JsonReader(new FileReader("src/test/resources/starships.json"));
        StarshipData starshipData = gson.fromJson(reader, StarshipData.class); // contains the whole reviews list
        System.out.println(starshipData);
    }

}