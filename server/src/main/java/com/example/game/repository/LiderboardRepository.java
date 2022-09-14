package com.example.game.repository;

import com.example.game.entity.Liderboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiderboardRepository extends JpaRepository<Liderboard, Long> {
}
