package com.example.ecommerce_backend.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "web_order")
public class WebOrder {

    @Id
    @Column(name = "web_orderId", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long webOrderId;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "webOrder", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<OrderQuantities> orderQuantities = new ArrayList<>();


    public List<OrderQuantities> getOrderQuantities() {
        return orderQuantities;
    }

    public void setOrderQuantities(List<OrderQuantities> orderQuantities) {
        this.orderQuantities = orderQuantities;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Long getWebOrderId() {
        return webOrderId;
    }

    public void setWebOrderId(Long webOrderId) {
        this.webOrderId = webOrderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
