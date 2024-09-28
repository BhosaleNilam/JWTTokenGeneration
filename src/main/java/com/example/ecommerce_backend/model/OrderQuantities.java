package com.example.ecommerce_backend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "order_quantities")
public class OrderQuantities {

    @Id
    @Column(name = "order_quantities_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderQuantityId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;


    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private WebOrder webOrder;

    public WebOrder getWebOrder() {
        return webOrder;
    }

    public void setWebOrder(WebOrder webOrder) {
        this.webOrder = webOrder;
    }

    public Long getOrderQuantityId() {
        return orderQuantityId;
    }

    public void setOrderQuantityId(Long orderQuantityId) {
        this.orderQuantityId = orderQuantityId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
