package com.ticket_dashboard.portal_api.security.service;

import com.ticket_dashboard.portal_api.security.AppUserPrincipal;
import com.ticket_dashboard.portal_api.user.entity.AppUser;
import com.ticket_dashboard.portal_api.user.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    public DatabaseUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    /**
     * loadUserByUsername - Looks up user by email
     * If no user exists, throw UsernameNotFoundException.
     * Does NOT verify the password
     */
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        AppUser user = appUserRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return new AppUserPrincipal(user);
    }
}
