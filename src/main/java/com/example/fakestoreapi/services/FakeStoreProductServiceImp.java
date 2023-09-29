package com.example.fakestoreapi.services;

import com.example.fakestoreapi.DTOs.ProductDTO;
import com.example.fakestoreapi.models.Category;
import com.example.fakestoreapi.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceImp implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    public FakeStoreProductServiceImp (RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }
    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDTO[]> l=restTemplate.getForEntity(
                "https://fakestoreapi.com/products",
                ProductDTO[].class);

        List<Product> answer= new ArrayList<>();

        for(ProductDTO productDTO: l.getBody()){
            Product product=new Product();
            product.setId(productDTO.getId());
            product.setTitle(productDTO.getTitle());
            product.setPrice(productDTO.getPrice());
            Category category=new Category();
            category.setName(productDTO.getCategory());
            product.setCategory(category);
            product.setImage(productDTO.getImage());
            answer.add(product);
        }
        return answer;
    }



    //return a product object with all the details of the fetched product
    // The id of category will be null but name of category shall be correct
    @Override
    public Product getSingleProduct(Long productId) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDTO> response= restTemplate.getForEntity("https://fakestoreapi.com/products/{1}",ProductDTO.class,productId);
        //( URL, returnType,params_in_url)
        ProductDTO productDTO=response.getBody();
        Product product=new Product();
        product.setId(productDTO.getId());
        product.setTitle(productDTO.getTitle());
        product.setPrice(productDTO.getPrice());
        Category category=new Category();
        category.setName(productDTO.getCategory());
        product.setCategory(category);
        product.setImage(productDTO.getImage());

        return product;
    }

    @Override
    public Product addNewProduct(ProductDTO product) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<ProductDTO> response= restTemplate.postForEntity("https://fakestoreapi.com/products",
                product,
                ProductDTO.class);
        ProductDTO productDTO = response.getBody();
        Product product1=new Product();
        product1.setId(productDTO.getId());
        product1.setTitle(productDTO.getTitle());
        product1.setPrice(productDTO.getPrice());
        Category category=new Category();
        category.setName(productDTO.getCategory());
        product1.setCategory(category);
        product1.setImage(productDTO.getImage());

        return product1;
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    public Product updateProduct(Long productId) {
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
        return null;
    }
}
