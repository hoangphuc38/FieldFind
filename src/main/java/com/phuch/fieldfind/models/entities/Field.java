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
@Table(name = "field", indexes = {
        @Index(name = "FieldTypeID", columnList = "FieldTypeID"),
        @Index(name = "OwnerID", columnList = "OwnerID"),
        @Index(name = "index_field_name", columnList = "Name")
})
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FieldID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FieldTypeID")
    private FieldType fieldTypeID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OwnerID")
    private FieldOwner ownerID;

    @Column(name = "Name", length = 100)
    private String name;

    @Column(name = "Address", length = 100)
    private String address;

    @Column(name = "Latitude")
    private Float latitude;

    @Column(name = "Longitude")
    private Float longitude;

    @Column(name = "TimeOpen")
    private Instant timeOpen;

    @Column(name = "TimeClosed")
    private Instant timeClosed;

    @Column(name = "CreatedAt")
    private Instant createdAt;

    @Column(name = "UpdatedAt")
    private Instant updatedAt;

    @OneToMany(mappedBy = "fieldID")
    private Set<Booking> bookings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "fieldID")
    private Set<FavouriteField> favouritefields = new LinkedHashSet<>();

    @OneToMany(mappedBy = "fieldID")
    private Set<Feedback> feedbacks = new LinkedHashSet<>();

}