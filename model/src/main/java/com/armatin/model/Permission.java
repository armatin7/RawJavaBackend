package com.armatin.model;

import java.util.Set;

import javax.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "tbl_permission")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = {"id"})
@EntityListeners(AuditingEntityListener.class)
public class Permission extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", precision = 10)
    private Long id;

    @Column(name = "c_permission", nullable = false, unique = true)
    private String permission;

    @ManyToMany(mappedBy = "linkedPermissions")
    private Set<User> linkeUsers;
}
