package com.example.fakestoreapi.Clients.authenticationClient;

import com.example.fakestoreapi.Clients.authenticationClient.DTOs.ValidateTokenRequestDTO;
import com.example.fakestoreapi.Clients.authenticationClient.DTOs.ValidateTokenResponseDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class AuthenticationClient {
    private RestTemplateBuilder restTemplateBuilder;
    public AuthenticationClient(RestTemplateBuilder rs){
        this.restTemplateBuilder=rs;
    }
    public ValidateTokenResponseDTO validate(String token, Long userId){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ValidateTokenRequestDTO request=new ValidateTokenRequestDTO();
        request.setToken(token);
        request.setUserId(userId);
        ResponseEntity<ValidateTokenResponseDTO> l=restTemplate.postForEntity(
                "http://localhost:8090/auth/validate",
                request,
                ValidateTokenResponseDTO.class);

        return l.getBody();
    }

}
