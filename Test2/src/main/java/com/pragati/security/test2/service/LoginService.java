package com.pragati.security.test2.service;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class LoginService {

    private static final Map<String, String> USERS = new HashMap<>();
    private static final Map<String, Set<String>> ROLES = new HashMap<>();

    static {
        USERS.put("admin", "admin");

        Set<String> adminRoles = new HashSet<>();
        adminRoles.add("ADMIN");
        ROLES.put("admin", adminRoles);
    }

    public boolean validate(String username, String password) {
        String storedPassword = USERS.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public Set<String> getRoles(String username) {
        return ROLES.getOrDefault(username, new HashSet<>());
    }
}
