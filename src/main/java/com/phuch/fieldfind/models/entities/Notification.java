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
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "Title", length = 100)
    private String title;

    @Column(name = "Content", length = 200)
    private String content;

    @Column(name = "SentInfo", length = 100)
    private String sentInfo;

    @Column(name = "SentDate")
    private Instant sentDate;

    @OneToMany(mappedBy = "notification")
    private Set<NotificationReceiptor> notificationReceiptors = new LinkedHashSet<>();

}