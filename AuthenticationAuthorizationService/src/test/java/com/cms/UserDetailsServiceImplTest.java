package com.cms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImplTest {

    @Test
    public void test118LoadByUserName() {
        // Setup
        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();
        String username = "admin";
        String password = "password";

        // Request
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // Assert
        Assertions.assertNotNull(userDetails);
        Assertions.assertEquals(username, userDetails.getUsername());
        Assertions.assertEquals(password, userDetails.getPassword());
    }

    @Test
    public void test118LoadByUserNameForInvalidUser() {
        // Setup
        UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();
        String username = "invalid_user";

        // Assert
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername(username);
        });
    }

}
