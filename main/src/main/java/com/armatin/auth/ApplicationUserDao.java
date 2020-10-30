package com.armatin.auth;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<ApplicationUser> selectApplicationUserByUsername(String username) throws UsernameNotFoundException;

    boolean isUserValid(String username);

}
