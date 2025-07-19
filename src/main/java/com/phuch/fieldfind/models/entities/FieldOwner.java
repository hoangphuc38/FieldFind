package com.phuch.fieldfind.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "fieldowner", indexes = {
        @Index(name = "UserID", columnList = "UserID")
})
public class FieldOwner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OwnerID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User userID;

    @Column(name = "BusinessName", length = 100)
    private String businessName;

    @Column(name = "LicenseCode", length = 100)
    private String licenseCode;

    @Column(name = "CreatedAt")
    private Instant createdAt;

    @Column(name = "UpdatedAt")
    private Instant updatedAt;

    @OneToMany(mappedBy = "ownerID")
    private Set<Field> fields = new LinkedHashSet<>();

}