package com.example.tp_spring_security.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> roles = new HashSet<>();

    public AppUser() {
    }

    public AppUser(Object o, String user1, String number, ArrayList<Object> objects) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRole> roles) {
        this.roles = roles;
    }
    public AppUser(Long id, String username, String password, Set<AppRole> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles; // Assurez-vous que c'est un Set<AppRole>
    }

}
