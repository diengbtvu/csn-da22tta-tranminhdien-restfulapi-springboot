
package com.yourpackage.security;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implement user retrieval logic, e.g., from a database
        // Example:
        if ("user".equals(username)) {
            return org.springframework.security.core.userdetails.User
                .withUsername("user")
                .password("{noop}password")
                .authorities("ROLE_USER")
                .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}