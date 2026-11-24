package com.ticket_dashboard.portal_api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration  //identifies a class that defines Spring beans.
public class PasswordConfig {

    @Bean  //registers the returned object in Spring's application context
    public PasswordEncoder passwordEncoder() {
        // PasswordEncoder is an interface, keeping application independent of a particular hashing implementation.
        return new BCryptPasswordEncoder();
        // BCryptPasswordEncoder hashes passwords using bcrypt, which automatically generates a random salt for each hash.
    }
}
