package com.cms.controller;

import com.cms.dto.LoginForm;
import com.cms.dto.RegistrationForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody LoginForm loginForm) {
        // Logic to authenticate the user
        // Return appropriate response based on authentication result
        return "User Logged In";
    }

    @PostMapping("/register")
    public String register(@RequestBody RegistrationForm registrationForm) {
        // Logic to register a new user
        // Return appropriate response based on registration result
        return "User Registered";
    }

    @PostMapping("/logout")
    public String logout() {
        // Logic to logout the user
        // Return appropriate response
        return "User Logged Out";
    }
}
