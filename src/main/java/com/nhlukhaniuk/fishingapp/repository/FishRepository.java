package com.nhlukhaniuk.fishingapp.repository;

import com.nhlukhaniuk.fishingapp.model.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FishRepository extends JpaRepository<Fish, UUID> {
}
