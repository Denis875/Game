package com.example.game.services;

import com.example.game.entity.User;
import com.example.game.entity.enums.ERole;
import com.example.game.exceptions.UserExistException;
import com.example.game.payload.request.SignupRequest;
import com.example.game.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(SignupRequest userIn){
        User user = new User();
        user.setEmail(userIn.getEmail());
        user.setUsername(userIn.getUsername());
        user.setPassword(passwordEncoder.encode(userIn.getPassword()));
        user.getRole().add(ERole.ROLE_USER);

        try{
            LOG.info("Save User {}",userIn.getEmail());
            return userRepository.save(user);
        }catch (Exception ex){
            LOG.error("Error during registration {}", ex.getMessage());
            throw new UserExistException("The user " + user.getUsername() + " already exist.");
        }
    }
}
