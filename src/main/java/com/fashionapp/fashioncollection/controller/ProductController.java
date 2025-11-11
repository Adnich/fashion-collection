package com.fashionapp.fashioncollection.controller;

import com.fashionapp.fashioncollection.model.Review;
import com.fashionapp.fashioncollection.repository.ReviewRepository;

import com.fashionapp.fashioncollection.model.Product;
import com.fashionapp.fashioncollection.repository.ProductRepository;
import com.fashionapp.fashioncollection.repository.CategoryRepository;
import com.fashionapp.fashioncollection.repository.BrandRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;
    private final BrandRepository brandRepo;
    private final ReviewRepository reviewRepo;

    public ProductController(ProductRepository productRepo,
                             CategoryRepository categoryRepo,
                             BrandRepository brandRepo,
                             ReviewRepository reviewRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
        this.brandRepo = brandRepo;
        this.reviewRepo = reviewRepo;
    }

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "products";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("brands", brandRepo.findAll());
        return "product-form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product,
                              @RequestParam("brand.id") Long brandId,
                              @RequestParam("category.id") Long categoryId) {

        product.setBrand(brandRepo.findById(brandId).orElseThrow());
        product.setCategory(categoryRepo.findById(categoryId).orElseThrow());
        productRepo.save(product);

        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productRepo.findById(id).orElseThrow());
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("brands", brandRepo.findAll());
        return "product-form";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepo.deleteById(id);
        return "redirect:/products";
    }

    // ✅ JEDINI ispravan detaljni prikaz proizvoda
    @GetMapping("/{id}")
    public String viewProduct(@PathVariable Long id, Model model) {
        Product product = productRepo.findById(id).orElseThrow();
        model.addAttribute("product", product);
        model.addAttribute("reviews", product.getReviews());
        model.addAttribute("newReview", new Review());
        return "product-details";
    }

    // ✅ Dodavanje recenzije
    @PostMapping("/{id}/reviews")
    public String addReview(@PathVariable Long id, @ModelAttribute("newReview") Review review) {
        Product product = productRepo.findById(id).orElseThrow();
        review.setProduct(product);
        reviewRepo.save(review);
        return "redirect:/products/" + id;
    }
}
