package com.yambacode.swapi.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.yambacode.swapi.model.Starship;
import com.yambacode.swapi.model.StarshipData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class StarshipLoader {

    private static Logger LOGGER = LoggerFactory.getLogger(StarshipLoader.class);


    public static final String PATH_TO_STARSHIPS = "src/main/resources/starships.json";

    private Gson gson;

    private AtomicInteger newId = new AtomicInteger(1);

    public StarshipLoader() throws FileNotFoundException {
        JsonReader reader = new JsonReader(new FileReader(PATH_TO_STARSHIPS));
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        this.gson = gsonBuilder.create();
    }


    public StarshipLoader(String path) throws FileNotFoundException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls();
        this.gson = gsonBuilder.create();
    }

    public List<Starship> loadStarships() {
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(PATH_TO_STARSHIPS));
            StarshipData starshipData = gson.fromJson(reader, StarshipData.class);

            return starshipData.getStarships().stream().map(
                    starship -> {
                        starship.setStarshipId(newId.toString());
                        newId.getAndIncrement();
                        return starship;
                    }

            ).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            LOGGER.error("Unable to load starships from json");
        }
        return new ArrayList<>();
    }


}
