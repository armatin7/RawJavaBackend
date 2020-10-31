package com.armatin.model;

import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tbl_user_roles")
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", precision = 10)
    private Long id;

    @Column(name = "c_role")
    private String role;

    @ManyToOne()
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;
    
    @Column(name = "user_id")
    private Long userId;
}
