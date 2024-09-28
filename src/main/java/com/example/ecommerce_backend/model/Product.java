package com.example.ecommerce_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "short_description", nullable = false)
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;

    @Column(name = "price", nullable = false)
    private double price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Long getId() {
        return productId;
    }

    public void setId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
