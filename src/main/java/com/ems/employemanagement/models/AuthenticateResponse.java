package com.ems.employemanagement.models;

public class AuthenticateResponse {
    private final String token;

    public AuthenticateResponse(String token) {
        this.token = token;
    }


    public String getToken() {
        return token;
    }
}
