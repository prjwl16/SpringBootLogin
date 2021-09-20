package com.assgn.signUp.io.responses;

public class LoginResponse {
    String username;
    int id;
    String token;
    String error;

    public LoginResponse(String error) {
        this.error=error;
        System.out.println("ERROR: "+error);
    }
    public LoginResponse(){

    }

    public LoginResponse(String username, int id, String token) {
        this.username = username;
        this.id = id;
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
//        System.out.println(username+" "+id+" "+token);
        return "loginResponse{" +
                "username='" + username + '\'' +
                ", id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
