package com.fashionapp.fashioncollection.data;

import com.fashionapp.fashioncollection.model.*;
import java.util.*;

public class DemoData {

    public static List<Brand> brands = new ArrayList<>();

    static {
        // Proizvodi
        Product p1 = new Product(1L, "Denim Jacket", "Jakna", 89.99, "Plava");
        Product p2 = new Product(2L, "Summer Dress", "Haljina", 59.99, "Crvena");
        Product p3 = new Product(3L, "Sneakers", "Obuća", 120.00, "Bijela");
        Product p4 = new Product(4L, "Leather Bag", "Torba", 150.00, "Crna");
        Product p5 = new Product(5L, "Classic T-Shirt", "Majica", 25.00, "Bijela");

        // Brendovi
        Brand b1 = new Brand(1L, "Zara", "Španija", "Amancio Ortega", 1975, Arrays.asList(p1, p2, p5));
        Brand b2 = new Brand(2L, "Nike", "SAD", "Phil Knight", 1964, Arrays.asList(p3));
        Brand b3 = new Brand(3L, "Gucci", "Italija", "Guccio Gucci", 1921, Arrays.asList(p4));

        // Dodaj u listu
        brands.add(b1);
        brands.add(b2);
        brands.add(b3);
    }
}
