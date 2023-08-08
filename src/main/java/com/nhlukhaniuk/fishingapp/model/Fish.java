package com.nhlukhaniuk.fishingapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "fishes")
public class Fish {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "place")
    @Enumerated(EnumType.STRING)
    private Place place;

    @Column(name = "photos")
    private Blob photo;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private User user;

    public Fish(String name, Double weight, Place place, Blob photo, String description) {
        this.name = name;
        this.weight = weight;
        this.place = place;
        this.photo = photo;
        this.description = description;
    }

    public Fish(String name, Double weight, Place place, Blob photo, String description, User user) {
        this.name = name;
        this.weight = weight;
        this.place = place;
        this.photo = photo;
        this.description = description;
        this.user = user;
    }
}
