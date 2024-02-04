package com.example.fakestoreapi.Clients.authenticationClient.DTOs;

import com.example.fakestoreapi.Clients.authenticationClient.DTOs.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenResponseDTO {
    private UserDTO userDto;
    private SessionStatus sessionStatus;
}
