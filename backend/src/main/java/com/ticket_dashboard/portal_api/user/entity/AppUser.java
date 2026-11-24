package com.ticket_dashboard.portal_api.user.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Mapping PostgreSQL app_users table to a Java class using JPA (Jakarta Persistence).
 * Represents a user stored in PostgreSQL
 */
@Entity
@Table(name = "app_users")
public class AppUser {
    //-- FIELDS --//

    // PRIMARY KEY
    @Id    // identifies entity's primary key
    @GeneratedValue(strategy = GenerationType.UUID)   // tells Hibernate to generate the identifier automatically
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;    // matches PostgreSQL UUID type

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;   // Stores bycrypt hash, NEVER PLAINTEXT PASSWORD

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    // insertable= false means Hibernate omits this column from INSERT statements, allowing PostgreSQL to apply its default.
    // updatable = false means Hibernate won't modify the timestamp during updates
    private LocalDateTime createdAt;


    //-- CONSTRUCTORS --//

    // No args constructor - so Hibernate can instantiate JPA entities when retrieving records from the database.
    // Protected means other classes are discouraged from creating an AppUser without providing the required information.
    protected AppUser() {
    }

    // Args constructor
    public AppUser(String firstName, String lastName, String email, String passwordHash, UserRole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
    }


    //-- GETTERS & SETTERS--//


    public UUID getId() {
        return id;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() { return lastName; }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public UserRole getRole() {
        return role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
