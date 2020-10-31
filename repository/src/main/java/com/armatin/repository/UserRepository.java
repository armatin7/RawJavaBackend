package com.armatin.repository;

import com.armatin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUsersByUsername(@Param("username")String username);

    boolean existsByUsername(String username);

    @Query(value = "SELECT " +
    "CASE WHEN EXISTS" +
    "(SELECT * FROM spring.tbl_user user " +
    "WHERE  user.c_username = :username and user.b_is_active) " +
    "THEN 'true' " +
    "ELSE 'false' " +
    "END", nativeQuery = true)
    boolean isUserActive(@Param("username") String username);
}
