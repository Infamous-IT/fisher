package com.nhlukhaniuk.fishingapp.dto;

import com.nhlukhaniuk.fishingapp.model.Fish;
import com.nhlukhaniuk.fishingapp.model.Roles;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class UserDTO {

    private UUID id;
    private String username;
    private String password;
    private Roles role;
    private List<Fish> fish;

    public UserDTO() {
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
