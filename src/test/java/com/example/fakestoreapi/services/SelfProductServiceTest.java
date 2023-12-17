package com.example.fakestoreapi.services;

import com.example.fakestoreapi.exceptions.NotFoundException;
import com.example.fakestoreapi.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import  static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SelfProductServiceTest {
    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private SelfProductService selfProductService;

    @Test
    void TestGetSingleProductThrowsExceptionWhenNoSuchProductFound(){
//        when(productRepository.findProductById(1L)).thenReturn(null);
//        when(productRepository.findProductById(any())).thenCallRealMethod();

        when(productRepository.findProductById(any())).thenReturn(null);

        assertThrows(NotFoundException.class, () ->selfProductService.getSingleProduct(1L));

    }

}