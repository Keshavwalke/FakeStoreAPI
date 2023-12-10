package com.example.fakestoreapi.repositories;

import com.example.fakestoreapi.models.Category;
import com.example.fakestoreapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepository extends JpaRepository<Category , Long> {

    List<String> findAllTitlesBy();


    @Query(value =Queries.ProductsInCate, nativeQuery = true)
    List<Product> getProductsInCategory(String title);
}
