package com.ticket_dashboard.portal_api.auth.controller;

import com.ticket_dashboard.portal_api.auth.dto.CurrentUserResponse;
import com.ticket_dashboard.portal_api.security.AppUserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @AuthenticationPrincipal tells Spring Security to retrieve the principal from the current authenticated user's security context and inject it directly into the controller method.
 * getName() returns the authenticated user's email
 * getAuthorities() returns their granted authorities
 */
@RestController
public class AuthController {

    @GetMapping("/api/auth/me")
    // change map to DTO
    public CurrentUserResponse getCurrentUser(
            @AuthenticationPrincipal AppUserPrincipal principal) {
        return new CurrentUserResponse(
                principal.getId(),
                principal.getFirstName(),
                principal.getLastName(),
                principal.getUsername(),
                principal.getAuthorities()
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .filter(authority -> authority.startsWith("ROLE_"))
                        .toList()
        );
    }
}
