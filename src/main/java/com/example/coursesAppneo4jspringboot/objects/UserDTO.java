package com.example.coursesAppneo4jspringboot.objects;

public class UserDTO {

    private String username;
    private String name;
    private String roles;

    public UserDTO(String username, String name, String roles) {
        this.username = username;
        this.name = name;
        this.roles = roles;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
