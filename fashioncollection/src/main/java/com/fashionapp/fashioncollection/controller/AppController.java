package com.fashionapp.fashioncollection.controller;

import com.fashionapp.fashioncollection.data.DemoData;
import com.fashionapp.fashioncollection.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

    // Ruta za listu brendova
    @GetMapping("/brands")
    public String showBrands(Model model) {
        model.addAttribute("brands", DemoData.brands);
        return "listBrands";  // Thymeleaf stranica listBrands.html
    }

    // Ruta za prikaz proizvoda određenog brenda
    @GetMapping("/products/{brandId}")
    public String showProducts(@PathVariable Long brandId, Model model) {
        Brand brand = DemoData.brands.stream()
                .filter(b -> b.getId().equals(brandId))
                .findFirst()
                .orElse(null);
        model.addAttribute("brand", brand);
        return "listProducts"; // Thymeleaf stranica listProducts.html
    }

    // Ruta za "akciju" – npr. prikaz prosječne cijene proizvoda
    @GetMapping("/brands/action/{id}")
    public String brandAction(@PathVariable Long id, Model model) {
        Brand brand = DemoData.brands.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElse(null);

        double avg = 0;
        if (brand != null && brand.getProducts() != null && !brand.getProducts().isEmpty()) {
            avg = brand.getProducts().stream().mapToDouble(Product::getPrice).average().orElse(0);
        }

        model.addAttribute("brand", brand);
        model.addAttribute("averagePrice", avg);
        return "action"; // Thymeleaf stranica action.html
    }
}
