package com.example.game.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_item",unique = true, nullable = false)
    private String nameItem;
    @Column(nullable = false)
    private Long price;
    private Long count;
    @Column(columnDefinition = "text")
    private String description;
}
