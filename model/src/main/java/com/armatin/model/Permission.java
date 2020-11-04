package com.armatin.model;

import java.util.Set;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_user_permissions")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", precision = 10)
    private Long id;

    @Column(name = "c_permission")
    private String permission;

    @ManyToMany(mappedBy = "linkedPermissions")
    private Set<User> linkeUsers;
}
