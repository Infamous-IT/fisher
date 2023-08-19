package com.nhlukhaniuk.fishingapp.service;

import com.nhlukhaniuk.fishingapp.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserDTO> get();

    UserDTO update(UserDTO userDTO);

    UserDTO create(UserDTO userDTO);

    UserDTO getById(UUID uuid);

    void delete(UUID uuid);
}
