package com.fashionapp.fashioncollection.model;

public class Product {
    private Long id;
    private String name;
    private String category;
    private double price;
    private String color;

    public Product(Long id, String name, String category, double price, String color) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.color = color;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public String getColor() { return color; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }
    public void setColor(String color) { this.color = color; }
}
