package com.fashionapp.fashioncollection.model;

import java.util.List;

public class Brand {
    private Long id;
    private String name;
    private String country;
    private String founder;
    private int foundedYear;
    private List<Product> products;

    public Brand(Long id, String name, String country, String founder, int foundedYear, List<Product> products) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.founder = founder;
        this.foundedYear = foundedYear;
        this.products = products;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCountry() { return country; }
    public String getFounder() { return founder; }
    public int getFoundedYear() { return foundedYear; }
    public List<Product> getProducts() { return products; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCountry(String country) { this.country = country; }
    public void setFounder(String founder) { this.founder = founder; }
    public void setFoundedYear(int foundedYear) { this.foundedYear = foundedYear; }
    public void setProducts(List<Product> products) { this.products = products; }
}
