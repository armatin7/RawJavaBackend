package com.armatin.model;

import java.util.Set;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_user_roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", precision = 10)
    private Long id;

    @Column(name = "c_role")
    private String role;

    @ManyToMany(mappedBy = "linkedRoles")
    private Set<User> linkeUsers;
}
