package com.example.fakestoreapi.Clients.fakeStore;
import com.example.fakestoreapi.DTOs.ProductDTO;
import com.example.fakestoreapi.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreClient(RestTemplateBuilder rs){
        this.restTemplateBuilder=rs;
    }
    public List<FakeStoreProductDTO> getAllProducts(){
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> l=restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);
        return Arrays.asList(l.getBody());
    }
    public Optional<FakeStoreProductDTO> getSingleProduct(Long productId){
        return null;
    }
    public FakeStoreProductDTO addNewProduct( ProductDTO productDTO){
        return null;
    }

    // product  object has only those fields filled which needs to be updated, other things are null
    public FakeStoreProductDTO updateProduct(Long productId,Product product ){
        return null;
    }
    public FakeStoreProductDTO replaceProduct(Long productId,Product product ){
        return null;
    }
    public FakeStoreProductDTO deleteProduct( Long productId){
        return null;
    }

}
