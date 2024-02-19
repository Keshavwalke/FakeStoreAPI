package com.example.fakestoreapi.services;

import com.example.fakestoreapi.Clients.fakeStore.FakeStoreProductDTO;
import com.example.fakestoreapi.DTOs.ProductDTO;
import com.example.fakestoreapi.DTOs.RatingDTO;
import com.example.fakestoreapi.exceptions.NotFoundException;
import com.example.fakestoreapi.models.Category;
import com.example.fakestoreapi.models.Product;
import com.example.fakestoreapi.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Primary
public class SelfProductService implements ProductService{
    ProductRepository productRepository;
    public SelfProductService(ProductRepository productRepository){
       this.productRepository=productRepository;
    }

    private Product convertProductDtoToProduct(ProductDTO pdto){
        Product product=new Product();
        product.setId(pdto.getId());
        product.setTitle(pdto.getTitle());
        product.setDescription(pdto.getDescription());
        product.setPrice(pdto.getPrice());
        product.setImage(pdto.getImage());
        Category category=new Category();
        category.setTitle(pdto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public List<Product> getAllProducts() {
         return productRepository.findAll();
    }

    @Override
    public Optional<Product> getSingleProduct(Long productId) throws NotFoundException {
        Product product=productRepository.findProductById(productId);
        if (product==null){
            throw new NotFoundException("Product doesn't exist");
        }
        return Optional.of(product);
    }

    @Override
    public Product addNewProduct(ProductDTO productDTO) {
        Product product=convertProductDtoToProduct(productDTO);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
//        Product product=convertProductFromDTOForUpdate(productDTO);
//        return productRepository.updateProductById(productId, product);
        return null;
    }

    @Override
    public Product replaceProduct(Long productId, Product product) {
      //  return productRepository.updateProductById(productId, product);
        return null;
    }

    @Override
    public Product deleteProduct(Long productId) {
     //   return productRepository.deleteProductById(productId);
        return null;
    }

    public Product convertProductFromDTOForUpdate(ProductDTO pdto){
        Product product=new Product();
        product.setTitle(pdto.getTitle());
        product.setDescription(pdto.getDescription());
        product.setPrice(pdto.getPrice());
        product.setImage(pdto.getImage());
        Category category=new Category();
        category.setTitle(pdto.getCategory());
        product.setCategory(category);
        return product;
    }
}
