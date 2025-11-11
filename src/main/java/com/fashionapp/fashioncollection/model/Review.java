package com.fashionapp.fashioncollection.model;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;
    private String comment;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Review() {}

    public Long getId() { return id; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}
