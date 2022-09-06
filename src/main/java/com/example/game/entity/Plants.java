package com.example.game.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Plants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "buy_price")
    private Long buyPrice;
    @Column(name = "sell_price")
    private Long sellPrice;
    @Column(name = "time_grow")
    private Long timeGrow;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Fields fields;
}
