package com.example.game.repository;

import com.example.game.entity.Growing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrowingRepository extends JpaRepository<Growing, Long> {
}
