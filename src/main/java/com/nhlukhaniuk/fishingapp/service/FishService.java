package com.nhlukhaniuk.fishingapp.service;

import com.nhlukhaniuk.fishingapp.dto.FishDTO;

import java.util.List;
import java.util.UUID;

public interface FishService {

    List<FishDTO> get();

    FishDTO update(FishDTO fishDTO);

    FishDTO create(FishDTO fishDTO);

    FishDTO getById(UUID uuid);

    void delete(UUID uuid);
}
