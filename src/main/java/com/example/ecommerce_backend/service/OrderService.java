package com.example.ecommerce_backend.service;

import com.example.ecommerce_backend.model.User;
import com.example.ecommerce_backend.model.WebOrder;
import com.example.ecommerce_backend.model.dao.WebOrderDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private WebOrderDAO webOrderDAO;

    public OrderService(WebOrderDAO webOrderDAO){
        this.webOrderDAO = webOrderDAO;
    }

    public List<WebOrder> getOrders(User user){
        return webOrderDAO.findByUser(user);
    }
}
