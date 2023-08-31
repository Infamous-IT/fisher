package com.nhlukhaniuk.fishingapp.controller;

import com.nhlukhaniuk.fishingapp.dto.FishDTO;
import com.nhlukhaniuk.fishingapp.service.FishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/secured/fish")
public class FishController {

    private FishServiceImpl fishService;

    @Autowired
    public FishController(FishServiceImpl fishService) {
        this.fishService = fishService;
    }

    @GetMapping
    public List<FishDTO> get() {
        return fishService.get();
    }

    @GetMapping(value = "/{id}")
    public FishDTO get(@PathVariable UUID id) {
        return fishService.getById(id);
    }

    @PostMapping(value = "/create")
    public FishDTO create(@RequestBody FishDTO fishDTO) {
        return fishService.create(fishDTO);
    }

    @PostMapping(value = "/update")
    public FishDTO update(@RequestBody FishDTO fishDTO) {
        return fishService.update(fishDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable UUID id) {
        fishService.delete(id);
    }
}
