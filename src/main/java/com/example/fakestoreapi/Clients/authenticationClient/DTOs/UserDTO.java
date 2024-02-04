package com.example.fakestoreapi.Clients.authenticationClient.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class UserDTO {
    private String email;

   private List<Role> roles= new ArrayList<>();

}
