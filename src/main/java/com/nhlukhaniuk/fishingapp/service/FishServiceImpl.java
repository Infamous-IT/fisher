package com.nhlukhaniuk.fishingapp.service;

import com.nhlukhaniuk.fishingapp.dto.FishDTO;
import com.nhlukhaniuk.fishingapp.mapper.FishMapper;
import com.nhlukhaniuk.fishingapp.model.Fish;
import com.nhlukhaniuk.fishingapp.repository.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class FishServiceImpl implements FishService {

    private FishMapper fishMapper;
    private FishRepository fishRepository;

    @Autowired
    public FishServiceImpl(FishMapper fishMapper, FishRepository fishRepository) {
        this.fishMapper = fishMapper;
        this.fishRepository = fishRepository;
    }

    @Override
    public List<FishDTO> get() {
        return fishMapper.fishToFishDTOList(fishRepository.findAll());
    }

    @Override
    public FishDTO update(FishDTO fishDTO) {
        Fish fish = fishMapper.fishDTOToFish(fishDTO);
        fishRepository.save(fish);
        return fishDTO;
    }

    @Override
    public FishDTO create(FishDTO fishDTO) {
        Fish fish = fishMapper.fishDTOToFish(fishDTO);
        Fish createdUser = fishRepository.save(fish);
        return fishMapper.fishToFishDTO(createdUser);
    }

    @Override
    public FishDTO getById(UUID uuid) {
        Fish fish = fishRepository.getReferenceById(uuid);

        if (fish == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Fish with id " + uuid + " was not found!");
        }

        return fishMapper.fishToFishDTO(fish);
    }

    @Override
    public void delete(UUID uuid) {
        fishRepository.deleteById(uuid);
    }
}
