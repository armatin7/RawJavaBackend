package com.armatin.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class User extends Auditable<String>{

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
	  name = "users_permissions",
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> linkedPermissions;

    @ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	  name = "users_roles",
	  joinColumns = @JoinColumn(name = "user_id"), 
	  inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> linkedRoles;

    @Column(name = "b_isAccountNonExpired")
    private boolean isAccountNonExpired;

    @Column(name = "b_isAccountNonLocked")
    private boolean isAccountNonLocked;

    @Column(name = "b_isCredentialsNonExpired")
    private boolean isCredentialsNonExpired;

    @Column(name = "b_isActive")
    private boolean isActive;
}
