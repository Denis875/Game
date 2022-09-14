package com.example.game.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Fields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String title;
    private Long coast;
}
