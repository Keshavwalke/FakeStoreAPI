package com.example.fakestoreapi.services;

import com.example.fakestoreapi.Clients.fakeStore.FakeStoreClient;
import com.example.fakestoreapi.Clients.fakeStore.FakeStoreProductDTO;
import com.example.fakestoreapi.DTOs.ProductDTO;
import com.example.fakestoreapi.models.Category;
import com.example.fakestoreapi.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Primary
public class FakeStoreProductServiceImp implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;
    private FakeStoreClient fakeStoreClient ;
    public FakeStoreProductServiceImp (RestTemplateBuilder restTemplateBuilder,FakeStoreClient fk){
        this.restTemplateBuilder=restTemplateBuilder;
        this.fakeStoreClient=fk;
    }

    private Product convertProductDtoToProduct(FakeStoreProductDTO fsdto){
        Product product=new Product();
        product.setId(fsdto.getId());
        product.setTitle(fsdto.getTitle());
        product.setPrice(fsdto.getPrice());
        Category category=new Category();
        category.setTitle(fsdto.getCategory());
        product.setCategory(category);
        product.setImage(fsdto.getImage());
        return product;
    }

    private <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request,
                                                   Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();

        RequestCallback requestCallback =restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
    @Override
    public List<Product> getAllProducts() {
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDTO[]> l=restTemplate.getForEntity(
//                "https://fakestoreapi.com/products",   //moved this to method in fkclient
//                FakeStoreProductDTO[].class);
        List<FakeStoreProductDTO> fakeStoreProductDTOS= fakeStoreClient.getAllProducts();

        List<Product> answer= new ArrayList<>();

        for(FakeStoreProductDTO productDTO: fakeStoreProductDTOS){
            answer.add(convertProductDtoToProduct(productDTO));
        }
        return answer;
    }

    //return a product object with all the details of the fetched product
    // The id of category will be null but name of category shall be correct
    @Override
//    public Product getSingleProduct(Long productId) {
//        RestTemplate restTemplate=restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDTO> response= restTemplate.getForEntity("https://fakestoreapi.com/products/{1}",FakeStoreProductDTO.class,productId);
//        //( URL, returnType,params_in_url)
//        FakeStoreProductDTO fsdto=response.getBody();
//
//        return convertProductDtoToProduct(fsdto);
//    }
    public Optional<Product> getSingleProduct(Long productId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response =  restTemplate.getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductDTO.class, productId);

        FakeStoreProductDTO productDto = response.getBody();
        if (productDto == null) {
            return Optional.empty();
        }
        return Optional.of(convertProductDtoToProduct(productDto));
    }

    @Override
    public Product addNewProduct(ProductDTO product) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response= restTemplate.postForEntity(
                "https://fakestoreapi.com/products", product,
                FakeStoreProductDTO.class);
        FakeStoreProductDTO productDTO = response.getBody();
        return convertProductDtoToProduct(productDTO);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        RestTemplate restTemplate = restTemplateBuilder.requestFactory(
                HttpComponentsClientHttpRequestFactory.class
        ).build();
//        restTemplate.pat

        FakeStoreProductDTO fakeStoreProductDto = new FakeStoreProductDTO();
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImage());
        fakeStoreProductDto.setPrice(product.getPrice());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setCategory(product.getCategory().getTitle());

        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDtoResponseEntity = requestForEntity(
                HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",
                fakeStoreProductDto,
                FakeStoreProductDTO.class,
                productId
        );

//        if (fakeStoreProductDtoResponseEntity.getHeaders())


        FakeStoreProductDTO fakeStoreProductDtoResponse = restTemplate.patchForObject(
                "https://fakestoreapi.com/products/{id}",
                fakeStoreProductDto,
                FakeStoreProductDTO.class,
                productId
        );

        return convertProductDtoToProduct(fakeStoreProductDtoResponse);

//        return convertFakeStoreProductDtoToProduct(fakeStoreProductDtoResponseEntity.getBody());
    }


    public Product replaceProduct(Long productId, Product product) {
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
