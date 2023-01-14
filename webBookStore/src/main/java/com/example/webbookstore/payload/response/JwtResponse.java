package com.example.webbookstore.payload.response;


import com.example.webbookstore.model.Role;

import java.io.Serializable;
import java.util.Set;


public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;

    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }
    private String type = "Bearer";
    private Integer id;
    private String username;

    private  String email;
    private Set<Role> roles;

    public JwtResponse( String accessToken, Integer id, String username, Set<Role> roles, String email) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public JwtResponse(String jwt, Integer id, String username, String email, Set<String> roles) {
    }



    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
