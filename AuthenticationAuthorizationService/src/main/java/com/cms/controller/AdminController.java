package com.cms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String adminDashboard() {
        return "Admin Dashboard";
    }

    @GetMapping("/users")
    public String getUsers() {
        return "List of Users";
    }

    @PostMapping("/users")
    public String createUser() {
        return "User Created";
    }

    // Add more methods for admin-related functionality

    @GetMapping("/products")
    public String getProducts() {
        return "List of Products";
    }

    @PostMapping("/products")
    public String createProduct() {
        return "Product Created";
    }
}
