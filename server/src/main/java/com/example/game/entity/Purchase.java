package com.example.game.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Store store;
    private Integer count;
    @Column(name = "total_price")
    private Long totalPrice;
}
