package com.ticket_dashboard.portal_api.auth.dto;

import java.util.List;
import java.util.UUID;

/**
 * Public API response
 * A concise Java feature for representing data using strong typing.
 * Java automatically generates the constructor, accessor methods, equals(), hashCode() and toString().
 * @param id
 * @param firstName
 * @param lastName
 * @param email
 * @param roles
 */
public record CurrentUserResponse(
    UUID id,
    String firstName,
    String lastName,
    String email,
    List<String> roles
) {}