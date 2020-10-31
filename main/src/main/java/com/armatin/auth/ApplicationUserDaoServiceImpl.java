package com.armatin.auth;

import com.armatin.model.User;
import com.armatin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("application")
@RequiredArgsConstructor
public class ApplicationUserDaoServiceImpl implements ApplicationUserDao{

    private final UserRepository userRepository;

    @Override
    @Transactional
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.getUsersByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Username %s not found", username)));

        ApplicationUser applicationUser = new ApplicationUser(user);

        return Optional.of(applicationUser);
    }

    @Override
    @Transactional
    public boolean isUserValid(String username) {
        return userRepository.isUserActive(username);//.existsByUsername(username);
    }
}
