package com.example.fakestoreapi.controller;

import com.example.fakestoreapi.Clients.authenticationClient.AuthenticationClient;
import com.example.fakestoreapi.Clients.authenticationClient.DTOs.Role;
import com.example.fakestoreapi.Clients.authenticationClient.DTOs.SessionStatus;
import com.example.fakestoreapi.Clients.authenticationClient.DTOs.ValidateTokenResponseDTO;
import com.example.fakestoreapi.DTOs.ErrorResposeDTO;
import com.example.fakestoreapi.DTOs.ProductDTO;
import com.example.fakestoreapi.exceptions.NotFoundException;
import com.example.fakestoreapi.models.Category;
import com.example.fakestoreapi.models.Product;
import com.example.fakestoreapi.repositories.ProductRepository;
import com.example.fakestoreapi.services.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    //created ref of ProductService +interface, code to interface principle
    //Our controller should not take model, they should take DTO's

    private ProductService productService;
    private ProductRepository productRepository;
    private AuthenticationClient authenticationClient;


    public ProductController(ProductService productService, ProductRepository productRepository, AuthenticationClient authenticationClient  ){
        this.productService=productService;
        this.productRepository=productRepository;
        this.authenticationClient=authenticationClient;
    }

    //Get All Products
    // Make only admins be able to access all products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(@Nullable @RequestHeader("AUTH_TOKEN") String token,
                                                        @Nullable @RequestHeader("USER_ID") Long userId) {
        // check if token exists
        if (token == null || userId == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        ValidateTokenResponseDTO response = authenticationClient.validate(token, userId);

        // check if token is valid
        if (response.getSessionStatus().equals(SessionStatus.INVALID)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

//        // check if user has permissions(can be replaced in springconfig file )
//        boolean isUserAdmin = false;
//        for (Role role : response.getUserDto().getRoles()) {
//            if (role.getRole().equals("ADMIN")) {
//                isUserAdmin = true;
//            }
//        }
//
//        if (!isUserAdmin) {
//            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        }
        List<Product> products= productService.getAllProducts();
        return  new ResponseEntity(products, HttpStatus.OK);
    }

    //Get a single product Way 1
//    @GetMapping("/products/{productId}")
//    public GetSingleProductResponseDTO getSingleProduct(@PathVariable("productId") Long productId){
//        GetSingleProductResponseDTO responseDTO=new GetSingleProductResponseDTO();
//        responseDTO.setProduct(productService.getSingleProduct(productId));
//        return responseDTO;
//    }


    //Way 2 get single product (added headers, HTTP status)
//    @GetMapping("/products/{productId}")
//    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId){
//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//        headers.add("auth-token", "Access is granted bro");
//        ResponseEntity<Product> response=new ResponseEntity<>(
//                productService.getSingleProduct(productId),
//                headers, HttpStatus.OK);
//        return response;
//    }
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("productId") Long productId) throws NotFoundException {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add(
                "auth-token", "noaccess4uheyhey"                //this is for adding header if you want
        );

        Optional<Product> productOptional = productService.getSingleProduct(productId);

        if (productOptional.isEmpty()) {
            throw new NotFoundException("No Product with product id: " + productId);
        }
        ResponseEntity<Product> response = new ResponseEntity(
                productService.getSingleProduct(productId),
                headers,
                HttpStatus.NOT_FOUND
        );
        return response;
    }


   // Add a new Product
    @PostMapping("/products")
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDTO productDTO){
        Product newPrduct=productService.addNewProduct(productDTO);
        ResponseEntity<Product> response= new ResponseEntity<>(
                newPrduct,HttpStatus.OK);
        return response;
    }

    //Update a new Product
    @PatchMapping("/products/{productId}")
    public Product updateProduct(@PathVariable("productId") Long productId,
                                 @RequestBody ProductDTO productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setCategory(new Category());
        product.getCategory().setTitle(productDto.getCategory());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        return productService.updateProduct(productId, product);
    }

    //Delete a product
    @DeleteMapping("/products/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "Deleting product with id " +productId ;
    }


    //We declared initially but its scope is limited to this class only
    //other way we created class ExceptionAdviceBro and moved this method there

//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ErrorResposeDTO> Handle404ErrorBro(Exception e){
//        ErrorResposeDTO errorResposeDTO=new ErrorResposeDTO();
//         errorResposeDTO.setErrorMessage(e.getMessage());
//         return new ResponseEntity<>(errorResposeDTO, HttpStatus.NOT_FOUND);
//    }


}
