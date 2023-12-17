package com.example.fakestoreapi.services;

import com.example.fakestoreapi.models.Category;
import com.example.fakestoreapi.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreCategoryServiceImp implements CategoryService {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreCategoryServiceImp(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    @Override
    public List<String> getAllCategories() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<String[]> l=restTemplate.getForEntity(
                "https://fakestoreapi.com/products/categories",
                String [].class);

        List<String> answer=new ArrayList<>();

        for(String st: l.getBody()){
            answer.add(st);
        }
        return answer;
    }

    @Override
    public List<Product> getProductsInCategory(String title) {
        return null;
    }

//    @Override
//    public List<Product> getProductsInCategory(Long categoryId) {
//        return null;
//    }
}
