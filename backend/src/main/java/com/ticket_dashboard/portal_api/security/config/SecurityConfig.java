package com.ticket_dashboard.portal_api.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * SecurityFilterChain defines the security filters and rules applied to HTTP requests.
 * Unauthenticated users retrieve a CSRF token, which they must then submit with their login request.
 * The endpoint will return a token in JSON, while Spring Security maintains the server-side token validation mechanism.
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Tell Spring Security to use CORS configuration when processing incoming requests
                .cors(Customizer.withDefaults())

                // authorizeHttpRequests() defines access requirements.
                .authorizeHttpRequests(auth -> auth
                        // allows unauthenticated users to submit login credentials.
                        .requestMatchers("/api/auth/login", "/api/auth/csrf").permitAll()
                        // anyRequest().authenticated() continues protecting every other endpoint.
                        .anyRequest().authenticated()
                )

                // Returns http 401 for an unauthenticated API request
                .exceptionHandling(exceptions -> exceptions
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.sendError(401, "Unauthorized");
                        })
                )

                // formLogin() enables Spring Security's built-in form-based login mechanism, including its default login page.
                .formLogin(form -> form
                        // direct to our FE login page
                        .loginProcessingUrl("/api/auth/login")
                        // status codes make it easier for FE to decide what to display
                        .successHandler((request, response, authentication) -> {
                            response.setStatus(200);
                        })
                        .failureHandler((request, response, exception) -> {
                            response.sendError(401, "Invalid credentials");
                        })
                )

        // Logout handled by Spring Security
        .logout(logout -> logout
                .logoutUrl("/api/auth/logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.setStatus(200);
                })
        );

        // http.build() constructs the configured filter chain.
        return http.build();
    }
}
