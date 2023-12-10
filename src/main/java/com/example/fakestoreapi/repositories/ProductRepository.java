package com.example.fakestoreapi.repositories;

import com.example.fakestoreapi.DTOs.ProductDTO;
import com.example.fakestoreapi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Product save(Product product);          //save product, update product
    List<Product> findAll();         //getAll products

    // Below both methods are similar
    Product findProductById(Long id);  //Product findProductByIdIs(Long id);
    Optional<Product> findById(Long id);    //Getting single product by id




//    Product updateProductById(Long id, Product product);
//
//    Product deleteProductById(Long id);


    //Native SQL queries-- Modify the query as required
   // @Query(value = "select * from product where id=:id", nativeQuery = true)
    @Query(value =Queries.BroGiveMyProduct, nativeQuery = true)  //use this, in future only change at one place
    Product BrogiveMyProduct(Long id);
    //its not mandatory to return product in custom query only, I can return anything


//    //JPA Queries--not very common, works like including java code
//    @Query("select p from Product  p where p.id= :id and p.category.title=:categorytitle")
//    public List<Product> getByidAndTitle(Long id, String categoryTitle);


    //finding product with categorytitle and catid attribute
//    List<Product> findProductByCategory_titleAndCategory_Id(String Catergory_title, Long Category_Id);
  //  select * from product where category_id=? and categoryName=?


}
