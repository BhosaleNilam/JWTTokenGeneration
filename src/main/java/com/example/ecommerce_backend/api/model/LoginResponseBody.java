package com.example.ecommerce_backend.api.model;

public class LoginResponseBody {
    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
