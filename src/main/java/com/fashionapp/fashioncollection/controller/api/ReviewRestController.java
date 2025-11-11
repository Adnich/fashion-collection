package com.fashionapp.fashioncollection.controller.api;

import com.fashionapp.fashioncollection.model.Review;
import com.fashionapp.fashioncollection.repository.ReviewRepository;
import com.fashionapp.fashioncollection.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewRestController {

    private final ReviewRepository reviewRepo;
    private final ProductRepository productRepo;

    public ReviewRestController(ReviewRepository reviewRepo, ProductRepository productRepo) {
        this.reviewRepo = reviewRepo;
        this.productRepo = productRepo;
    }

    // GET /api/reviews -> sve recenzije
    @GetMapping
    public List<Review> all() {
        return reviewRepo.findAll();
    }

    // GET /api/reviews/product/{productId} -> recenzije za jedan proizvod
    @GetMapping("/product/{productId}")
    public List<Review> byProduct(@PathVariable Long productId) {
        var product = productRepo.findById(productId).orElseThrow();
        return product.getReviews();
    }

    // POST /api/reviews -> kreiraj (JSON body)
    @PostMapping
    public Review create(@RequestBody Review payload) {
        // očekuje se da payload.product.id postoji
        var product = productRepo.findById(payload.getProduct().getId()).orElseThrow();
        payload.setProduct(product);
        return reviewRepo.save(payload);
    }
}
