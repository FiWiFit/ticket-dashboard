package com.ticket_dashboard.portal_api.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public UrlBasedCorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        // setAllowedOrigins trusts React development server
        config.setAllowedOrigins(List.of("http://localhost:5173"));

        // setAllowedMethods specifies these permitted HTTP methods
        config.setAllowedMethods(List.of(
                "GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"
        ));
        config.setAllowedHeaders(List.of(
                "Content-Type", "X-CSRF-TOKEN"
        ));

        // setAllowCredentials(true) allows credentialed cross-origin requests, including session cookies
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        // "/api/**" applies this policy only to API endpoints
        source.registerCorsConfiguration("/api/**", config);

        return source;
    }

}
