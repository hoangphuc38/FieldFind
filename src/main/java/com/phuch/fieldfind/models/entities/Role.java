package com.phuch.fieldfind.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleID", nullable = false)
    private Integer id;

    @Column(name = "RoleName", length = 20)
    private String roleName;

    @OneToOne(mappedBy = "roleID")
    private User user;

}