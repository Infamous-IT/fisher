package com.nhlukhaniuk.fishingapp.dto;

import com.nhlukhaniuk.fishingapp.model.Place;
import com.nhlukhaniuk.fishingapp.model.User;
import lombok.Data;

import java.sql.Blob;
import java.util.UUID;

@Data
public class FishDTO {

    private UUID id;
    private String name;
    private Double weight;
    private Place place;
    private Blob photo;
    private String description;
    private User user;

    public FishDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
