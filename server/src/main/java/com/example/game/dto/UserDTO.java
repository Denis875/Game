package com.example.game.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UserDTO {

    private Long id;
    private Long gold;
    @NotEmpty
    private String username;

}
