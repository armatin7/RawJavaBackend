package com.armatin.service;

import com.armatin.iService.IUserService;
import com.armatin.model.User;
import com.armatin.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getAuthorities());
        return auth.getName();
    }

    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userRepository
                .getUsersByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", userName)));
    }

}
