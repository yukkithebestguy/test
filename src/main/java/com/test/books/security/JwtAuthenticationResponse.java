package com.test.books.security;


import com.test.books.model.User;

import java.io.Serializable;


public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
    private final User user;

    public JwtAuthenticationResponse(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return this.token;
    }
    
    public User getUser() {
        return this.user;
    }
    
}
