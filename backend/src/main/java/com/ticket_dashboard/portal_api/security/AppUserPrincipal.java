package com.ticket_dashboard.portal_api.security;

import com.ticket_dashboard.portal_api.user.entity.AppUser;
import org.springframework.security.core.userdetails.User;

import java.util.UUID;

/**
 * A principal represents the identity of the authenticated user within Spring Security.
 * This is a custom User object that extends Spring Security's User.
 * Represents the user's identity within Spring Security.
 */
public class AppUserPrincipal extends User {

    private final UUID id;
    private final String firstName;
    private final String lastName;

    public AppUserPrincipal(AppUser user) {
        // Passes the authentication-related information to the parent class
        super(
                user.getEmail(),
                user.getPasswordHash(),
                User.builder()
                        .username(user.getEmail())
                        .password(user.getPasswordHash())
                        .roles(user.getRole().name())
                        .build()
                        .getAuthorities()
        );

        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}