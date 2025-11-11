package com.fashionapp.fashioncollection.repository;



import com.fashionapp.fashioncollection.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}
