package com.example.fakestoreapi;

import com.example.fakestoreapi.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProductController.class)

public class FunctionalTests {
    @Autowired   //This is object used for sending request
    private MockMvc mockMvc;
@Test
    void testGetAllProducts() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().is(200))
                .andExpect(header().exists("authorization"))
                .andExpect(content().string("{}"));
    }

    @Test
    void anotherTest(){
        System.out.println("random thing to print.........");
    }

}
