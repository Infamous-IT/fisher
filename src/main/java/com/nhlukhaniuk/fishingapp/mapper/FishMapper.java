package com.nhlukhaniuk.fishingapp.mapper;

import com.nhlukhaniuk.fishingapp.dto.FishDTO;
import com.nhlukhaniuk.fishingapp.model.Fish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FishMapper {

    FishDTO fishToFishDTO(Fish fish);
    List<FishDTO> fishToFishDTOList(List<Fish> fish);
    Fish fishDTOToFish(FishDTO fishDTO);
}
