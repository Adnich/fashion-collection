// src/main/java/com/fashionapp/fashioncollection/FashionCollectionApplication.java
package com.fashionapp.fashioncollection;

import com.fashionapp.fashioncollection.model.*;
import com.fashionapp.fashioncollection.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FashionCollectionApplication {
    public static void main(String[] args) {
        SpringApplication.run(FashionCollectionApplication.class, args);
    }

    @Bean
    CommandLineRunner seedData(CategoryRepository categoryRepo,
                               BrandRepository brandRepo,
                               ProductRepository productRepo) {
        return args -> {
            if (categoryRepo.count() == 0 && brandRepo.count() == 0 && productRepo.count() == 0) {
                Category c1 = categoryRepo.save(new Category("Jakna"));
                Category c2 = categoryRepo.save(new Category("Haljina"));
                Category c3 = categoryRepo.save(new Category("Obuća"));
                Category c4 = categoryRepo.save(new Category("Torba"));
                Category c5 = categoryRepo.save(new Category("Majica"));

                Brand b1 = brandRepo.save(new Brand("Zara", "Španija", "Amancio Ortega", 1975));
                Brand b2 = brandRepo.save(new Brand("Nike", "SAD", "Phil Knight", 1964));
                Brand b3 = brandRepo.save(new Brand("Gucci", "Italija", "Guccio Gucci", 1921));

                productRepo.save(new Product("Denim Jacket", 89.99, "Plava", c1, b1));
                productRepo.save(new Product("Summer Dress", 59.99, "Crvena", c2, b1));
                productRepo.save(new Product("Sneakers", 120.00, "Bijela", c3, b2));
                productRepo.save(new Product("Leather Bag", 150.00, "Crna", c4, b3));
                productRepo.save(new Product("Classic T-Shirt", 25.00, "Bijela", c5, b1));
            }
        };
    }
}
