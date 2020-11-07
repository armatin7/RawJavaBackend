package com.armatin.iService;

import com.armatin.model.Role;

public interface IRoleService {

    void createRole(Role role);

    Role getRoleByName(String name);
}
