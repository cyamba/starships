package com.yambacode.swapi.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

public class StarshipData {

    private List<Starship> starships;

    public List<Starship> getStarships() {
        return starships;
    }

    public void setStarships(List<Starship> starships) {
        this.starships = starships;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
