// src/main/java/com/fashionapp/fashioncollection/controller/api/BrandRestController.java
package com.fashionapp.fashioncollection.controller.api;

import com.fashionapp.fashioncollection.model.Brand;
import com.fashionapp.fashioncollection.repository.BrandRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandRestController {
    private final BrandRepository repo;

    public BrandRestController(BrandRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Brand> all() {
        return repo.findAll();
    }
}
