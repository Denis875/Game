package com.example.game.repository;

import com.example.game.entity.Plants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantsRepository extends JpaRepository<Plants, Long> {
//    Optional<Plants> findPlantsById(Long id);
}
