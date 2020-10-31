package com.armatin.model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", precision = 10)
    private Long id;

    @Column(name = "c_username", nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "c_password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<UserPermission> permissions;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<UserRole> roles;

    @Column(name = "b_isAccountNonExpired")
    private boolean isAccountNonExpired;

    @Column(name = "b_isAccountNonLocked")
    private boolean isAccountNonLocked;

    @Column(name = "b_isCredentialsNonExpired")
    private boolean isCredentialsNonExpired;

    @Column(name = "b_isActive")
    private boolean isActive;
}
