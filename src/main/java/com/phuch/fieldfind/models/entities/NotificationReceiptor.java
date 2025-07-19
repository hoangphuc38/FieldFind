package com.phuch.fieldfind.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "notificationreceiptor", indexes = {
        @Index(name = "NotificationID", columnList = "NotificationID"),
        @Index(name = "UserID", columnList = "UserID")
})
public class NotificationReceiptor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NotificationID")
    private Notification notificationID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User userID;

    @Column(name = "IsRead")
    private Boolean isRead;

}