package com.example.game.dto;

import lombok.Data;

@Data
public class GrowingDTO {
    private Long userId;
    private Long plantsId;
    private Long priceSell;
    private Integer count;
    private Long totalTime;
}
