package com.armatin.model;

import lombok.*;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", precision = 10)
    private Long id;

    @Column(name = "c_username", nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "c_password", nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	  name = "user_permissions", 
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions;

    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	  name = "user_roles", 
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column(name = "b_isAccountNonExpired")
    private boolean isAccountNonExpired;

    @Column(name = "b_isAccountNonLocked")
    private boolean isAccountNonLocked;

    @Column(name = "b_isCredentialsNonExpired")
    private boolean isCredentialsNonExpired;

    @Column(name = "b_isActive")
    private boolean isActive;
}
