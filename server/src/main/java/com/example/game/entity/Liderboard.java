package com.example.game.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Liderboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

    private User user;
}
