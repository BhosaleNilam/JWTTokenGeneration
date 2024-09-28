package com.example.ecommerce_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Address {

    @Id
    @Column(name = "address_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;


    @Column(name = "country", nullable = false, length = 75)
    private String country;

    @Column(name = "city", nullable = false)
    private String City;

    @Column(name = "address_line1", nullable = false, length = 520)
    private String addressLine1;

    @Column(name = "address_line2", nullable = false, length = 520)
    private String addressLine2;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Long getId() {
        return addressId;
    }

    public void setId(Long addressId) {
        this.addressId = addressId;
    }
}
