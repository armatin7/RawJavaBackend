package com.armatin.iService;

import com.armatin.model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUserService {
    void createUser(User user);

    String getCurrentUsername();

    User loadUserByUsername (String userName) throws UsernameNotFoundException;
}
