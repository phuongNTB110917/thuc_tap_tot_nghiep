package com.example.webbookstore.payload.response;

import com.example.webbookstore.model.Role;

import java.io.Serializable;
import java.util.Set;

public class JwtResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;

    private String type = "Bearer";
    private String email;
    private String username;
    private Integer accountId;
    private Set<String> roles;
    private String token;

    public JwtResponse(String accessToken, Integer accountId , String email , String username , Set<String> roles) {
        this.token = accessToken;
        this.accountId = accountId;
        this.email = email;
        this.username = username;
        this.roles = roles;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
