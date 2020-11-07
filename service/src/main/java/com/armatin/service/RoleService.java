package com.armatin.service;

import com.armatin.iService.IRoleService;
import com.armatin.model.Role;
import com.armatin.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public void createRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleRepository.getRoleByRole(name).orElseThrow(() ->new IllegalStateException("Role not found"));
    }
}
