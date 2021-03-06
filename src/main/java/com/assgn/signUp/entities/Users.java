package com.assgn.signUp.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

@SuppressWarnings("unused")

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

@Entity

@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id","username"}))
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    @Column(unique = true)
    private String username;
    private String password;

    public Users() {

    }

    public Users(int id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;

        System.out.println("Users called ");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
    }
}
