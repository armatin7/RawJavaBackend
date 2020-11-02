package com.armatin.repository;

import com.armatin.model.Permission;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, Long>{
    Optional<Permission> getPermissionByPermission(String permission);
}
