package com.cms.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/")
    public String getAllUsers() {
        // Logic to fetch all users from the database
        // Return a response with the list of users
        return "List of all users";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id) {
        // Logic to fetch a user by ID from the database
        // Return a response with the user details
        return "User with ID: " + id;
    }

    @PostMapping("/")
    public String createUser(@RequestBody UserForm userForm) {
        // Logic to create a new user
        // Extract user details from the UserForm object and save them to the database
        // Return a response indicating the successful creation of the user
        return "User created successfully";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id, @RequestBody UserForm userForm) {
        // Logic to update an existing user
        // Retrieve the user from the database by ID
        // Update the user details based on the values provided in the UserForm object
        // Save the updated user to the database
        // Return a response indicating the successful update of the user
        return "User updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        // Logic to delete a user from the database by ID
        // Return a response indicating the successful deletion of the user
        return "User deleted successfully";
    }
}
