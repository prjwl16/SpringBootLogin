package com.assgn.signUp.io.responses;

public class UserResponse {
    String username;
    String id;

    public UserResponse() {
    }

    public UserResponse(String username, String id) {
        this.username = username;
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
