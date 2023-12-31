package com.nhlukhaniuk.fishingapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Roles role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Fish> fish;

    public User(){}

    public User(String username, String password, Roles role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username, String password, Roles role, List<Fish> fish) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.fish = fish;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public List<Fish> getFish() {
        return fish;
    }

    public void setFish(List<Fish> fish) {
        this.fish = fish;
    }
}
