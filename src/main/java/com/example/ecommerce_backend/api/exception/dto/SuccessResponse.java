package com.example.ecommerce_backend.api.exception.dto;

import org.springframework.stereotype.Component;

@Component
public class SuccessResponse {
    private String message;
    private int statusCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
