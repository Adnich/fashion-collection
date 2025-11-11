package com.fashionapp.fashioncollection.model;

import jakarta.persistence.*;

@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String country;
    private String founder;
    private int foundedYear;

    public Brand() {}

    public Brand(String name, String country, String founder, int foundedYear) {
        this.name = name;
        this.country = country;
        this.founder = founder;
        this.foundedYear = foundedYear;
    }

    // GETTERI I SETTERI

    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getFounder() { return founder; }
    public void setFounder(String founder) { this.founder = founder; }

    public int getFoundedYear() { return foundedYear; }
    public void setFoundedYear(int foundedYear) { this.foundedYear = foundedYear; }
}
