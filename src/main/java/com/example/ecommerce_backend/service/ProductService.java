package com.example.ecommerce_backend.service;

import com.example.ecommerce_backend.model.Product;
import com.example.ecommerce_backend.model.dao.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductDAO productDAO;

    public ProductService(ProductDAO productDAO){
        this.productDAO = productDAO;
    }

    public List<Product> getAllProducts(){
        return productDAO.findAll();
    }
}
