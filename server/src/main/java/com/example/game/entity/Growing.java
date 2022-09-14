package com.example.game.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Growing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Plants plants;
    @Column(name = "price_sell")
    private Long priceSell;
    private Integer count = 0;
    @Column(name = "total_time")
    private Long totalTime;
}
