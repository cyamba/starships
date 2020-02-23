package com.yambacode.swapi.model;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Starship {


    @Id
    private String starshipId;

    private String name;
    private String model;
    private String manufacturer;

    @SerializedName("cost_in_credits")
    private String costInCredits;

    private Double length;
    @SerializedName("max_atmosphering_speed")
    private String maxAtmospheringSpeed;
    private Integer crew;
    private Integer passengers;
    @SerializedName("cargo_capacity")
    private String cargoCapacity;
    private String consumables;
    @SerializedName("hyperdrive_rating")
    private String hyperDriveRating;
    private Integer mgtl;
    @SerializedName("starship_class")
    private String starshipClass;
    private List<String> pilots;

    private List<String> films;
    private String created; //ISO_DATE_TIME
    private String edited;  //ISO_DATE_TIME
    private String url;

    public String getStarshipId() {
        return starshipId;
    }

    public void setStarshipId(String starshipId) {
        this.starshipId = starshipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCostInCredits() {
        return costInCredits;
    }

    public void setCostInCredits(String costInCredits) {
        this.costInCredits = costInCredits;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public String getMaxAtmospheringSpeed() {
        return maxAtmospheringSpeed;
    }

    public void setMaxAtmospheringSpeed(String maxAtmospheringSpeed) {
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
    }

    public Integer getCrew() {
        return crew;
    }

    public void setCrew(Integer crew) {
        this.crew = crew;
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public String getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(String cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperDriveRating() {
        return hyperDriveRating;
    }

    public void setHyperDriveRating(String hyperDriveRating) {
        this.hyperDriveRating = hyperDriveRating;
    }

    public Integer getMgtl() {
        return mgtl;
    }

    public void setMgtl(Integer mgtl) {
        this.mgtl = mgtl;
    }

    public String getStarshipClass() {
        return starshipClass;
    }

    public void setStarshipClass(String starshipClass) {
        this.starshipClass = starshipClass;
    }

    public List<String> getPilots() {
        return pilots;
    }

    public void setPilots(List<String> pilots) {
        this.pilots = pilots;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEdited() {
        return edited;
    }

    public void setEdited(String edited) {
        this.edited = edited;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    public static Starship of(String id, String costInCredits) {
        Starship starship = new Starship();
        starship.setStarshipId(id);
        starship.setCostInCredits(costInCredits);
        return starship;
    }
}
