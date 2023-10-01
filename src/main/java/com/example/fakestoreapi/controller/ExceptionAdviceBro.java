package com.example.fakestoreapi.controller;

import com.example.fakestoreapi.DTOs.ErrorResposeDTO;
import com.example.fakestoreapi.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice       //This annotation is mandatory
public class ExceptionAdviceBro {
    //Hey controller if you ever found NotFoundException.class exception return this method
    // controller is better way to catch the exception
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResposeDTO> Handle404ErrorBro(Exception e){
        ErrorResposeDTO errorResposeDTO=new ErrorResposeDTO();
        errorResposeDTO.setErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorResposeDTO, HttpStatus.NOT_FOUND);
    }

}
