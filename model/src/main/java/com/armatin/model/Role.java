package com.armatin.model;

import java.util.Set;

import javax.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tbl_user_roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Role extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", precision = 10)
    private Long id;

    @Column(name = "c_role")
    private String role;

    @ManyToMany(mappedBy = "linkedRoles")
    private Set<User> linkeUsers;
}
