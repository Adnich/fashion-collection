package com.fashionapp.fashioncollection.controller;

import com.fashionapp.fashioncollection.model.Brand;
import com.fashionapp.fashioncollection.model.Product;
import com.fashionapp.fashioncollection.repository.BrandRepository;
import com.fashionapp.fashioncollection.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "index"; // ako se stranica zove index.html
    }

    @GetMapping("/listBrands")
    public String brands(Model model) {
        model.addAttribute("brands", brandRepository.findAll());
        return "listBrands"; // stranica brands.html
    }


}
