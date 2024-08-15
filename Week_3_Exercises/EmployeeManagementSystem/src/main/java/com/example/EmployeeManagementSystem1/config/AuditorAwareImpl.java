package com.example.EmployeeManagementSystem1.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // You can fetch the current logged-in user from SecurityContext, etc.
        return Optional.of("admin"); // For simplicity, returning a static username
    }
}
