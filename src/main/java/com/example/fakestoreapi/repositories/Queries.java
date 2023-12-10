package com.example.fakestoreapi.repositories;

public interface Queries {
    //This is preferred way, by default they are public, static and final
    String BroGiveMyProduct="select * from product where id=:id";
    String ProductsInCate=" select * from product where category.title=:title";
}
