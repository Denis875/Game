package com.example.game.services;

import com.example.game.dto.GrowingDTO;
import com.example.game.entity.Growing;
import com.example.game.entity.Plants;
import com.example.game.entity.User;
import com.example.game.exceptions.PlantsNotFoundExeption;
import com.example.game.repository.GrowingRepository;
import com.example.game.repository.PlantsRepository;
import com.example.game.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class GrowingService {
    public static final Logger LOG = LoggerFactory.getLogger(GrowingService.class);

    private UserRepository userRepository;
    private PlantsRepository plantsRepository;
    private GrowingRepository growingRepository;

    @Autowired
    public GrowingService(UserRepository userRepository, PlantsRepository plantsRepository, GrowingRepository growingRepository) {
        this.userRepository = userRepository;
        this.plantsRepository = plantsRepository;
        this.growingRepository = growingRepository;
    }

    private Growing buyPlants(Long plantsId, Principal principal, GrowingDTO growingDTO){
        Plants plants = plantsRepository.findById(plantsId)
                .orElseThrow(() -> new PlantsNotFoundExeption("Plants not found"));
        User user = getUserByPrincipal(principal);
        Growing growing = new Growing();
        growing.setPlants(plants);
        growing.setUser(user);
        growing.setCount(growingDTO.getCount() + 1);
        growing.setPriceSell(plants.getSellPrice() * growingDTO.getCount());
        growing.setTotalTime(growingDTO.getTotalTime() + plants.getTimeGrow());
        return growingRepository.save(growing);
    }

    private User getUserByPrincipal(Principal principal){
        String username = principal.getName();
        return userRepository.findUserByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }
}
