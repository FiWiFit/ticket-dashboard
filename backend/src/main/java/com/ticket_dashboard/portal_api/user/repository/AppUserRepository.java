package com.ticket_dashboard.portal_api.user.repository;

import com.ticket_dashboard.portal_api.user.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Keeps database access separate from business logic
 * JpaRepository<AppUser, UUID> tells Spring Data JPA which entity the repository manages and the type of its primary key.
 * JpaRepository provides methods such as save(), findById(), findAll() and deleteById().
 * Spring Data JPA generates a repository implementation at runtime so no implementation is needed.
 */
public interface AppUserRepository extends JpaRepository<AppUser, UUID> {

    // Optional<AppUser> — the email might not exist in the database, so the method explicitly represents that possibility.
    // findByEmail — Spring Data JPA derives the database query from the method name.
    Optional<AppUser> findByEmail(String email);

}
