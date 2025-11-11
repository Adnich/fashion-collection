package com.fashionapp.fashioncollection.repository;

import com.fashionapp.fashioncollection.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {}
