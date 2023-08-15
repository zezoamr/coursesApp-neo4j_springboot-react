package com.example.coursesAppneo4jspringboot.requests;

public class CreateUserRequest {
    private String username;
    private String name;
    private String password;
    private String roles;

    public CreateUserRequest(String username, String name, String password, String role) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.roles = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
