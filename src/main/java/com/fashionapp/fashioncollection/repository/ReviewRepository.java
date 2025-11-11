package com.fashionapp.fashioncollection.repository;

import com.fashionapp.fashioncollection.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
