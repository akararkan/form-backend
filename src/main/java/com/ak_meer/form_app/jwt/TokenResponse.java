package com.ak_meer.form_app.jwt;

public class TokenResponse {
    private String token;

    // Constructors
    public TokenResponse() {}

    public TokenResponse(String token) {
        this.token = token;
    }

    // Getter and Setter
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}