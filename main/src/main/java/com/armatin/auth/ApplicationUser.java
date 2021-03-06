package com.armatin.auth;

import com.armatin.model.User;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@RequiredArgsConstructor
public class ApplicationUser implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final User user;

    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.isActive();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        this.user.getLinkedPermissions().forEach(p ->{
            GrantedAuthority authority = new SimpleGrantedAuthority(p.getPermission());
            grantedAuthorities.add(authority);
        });

        this.user.getLinkedRoles().forEach(r ->{
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r.getRole());
            grantedAuthorities.add(authority);
        });

        return grantedAuthorities;
    }
}
