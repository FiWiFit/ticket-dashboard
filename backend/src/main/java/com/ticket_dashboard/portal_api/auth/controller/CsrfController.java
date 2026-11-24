package com.ticket_dashboard.portal_api.auth.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Before FE can submit a login request, it needs a CSRF token.
 * Session cookies Security's CSRF protection enabled.
 */
@RestController
public class CsrfController {

    @GetMapping("/api/auth/csrf")
    public CsrfToken csrf(CsrfToken token) {
        return token;
    }
}
