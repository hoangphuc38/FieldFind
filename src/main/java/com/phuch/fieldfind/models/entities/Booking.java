package com.phuch.fieldfind.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "booking", indexes = {
        @Index(name = "FieldID", columnList = "FieldID"),
        @Index(name = "CustomerID", columnList = "CustomerID")
})
public class Booking {
    @Id
    @Column(name = "ID", nullable = false, length = 10)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FieldID")
    private Field fieldID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerID")
    private User customerID;

    @Column(name = "BookingDate")
    private Instant bookingDate;

    @Column(name = "TimeStart")
    private Instant timeStart;

    @Column(name = "TimeEnd")
    private Instant timeEnd;

    @Column(name = "TotalHour")
    private Float totalHour;

    @Column(name = "TotalPrice")
    private Float totalPrice;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "CreatedAt")
    private Instant createdAt;

    @Column(name = "UpdatedAt")
    private Instant updatedAt;

    @OneToOne(mappedBy = "bookingID")
    private Invoice invoice;

    @OneToOne(mappedBy = "bookingID")
    private Payment payment;

}