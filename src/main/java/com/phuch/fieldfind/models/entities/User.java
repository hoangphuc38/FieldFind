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
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(name = "RoleID", columnNames = {"RoleID"})
})
public class User {
    @Id
    @Column(name = "UserID", nullable = false, length = 10)
    private String userID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleID")
    private Role roleID;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "PasswordHash", length = 100)
    private String passwordHash;

    @Column(name = "FullName", length = 100)
    private String fullName;

    @Column(name = "Phone", length = 100)
    private String phone;

    @Column(name = "AvatarURL", length = 100)
    private String avatarURL;

    @Column(name = "CreatedAt")
    private Instant createdAt;

    @Column(name = "UpdatedAt")
    private Instant updatedAt;

    @OneToMany(mappedBy = "customerID")
    private Set<Booking> bookings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customerID")
    private Set<FavouriteField> favouritefields = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customerID")
    private Set<Feedback> feedbacks = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userID")
    private Set<FieldOwner> fieldowners = new LinkedHashSet<>();

    @OneToMany(mappedBy = "userID")
    private Set<NotificationReceiptor> notificationreceiptors = new LinkedHashSet<>();

    @OneToOne(mappedBy = "userID")
    private RefreshToken refreshtoken;

}