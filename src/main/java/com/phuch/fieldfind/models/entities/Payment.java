package com.phuch.fieldfind.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "payment", indexes = {
        @Index(name = "index_payment_bookingID", columnList = "BookingID")
}, uniqueConstraints = {
        @UniqueConstraint(name = "BookingID", columnNames = {"BookingID"}),
        @UniqueConstraint(name = "PaymentTypeID", columnNames = {"PaymentTypeID"})
})
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BookingID")
    private Booking bookingID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PaymentTypeID")
    private PaymentType paymentTypeID;

    @Column(name = "TransactionNo", length = 100)
    private String transactionNo;

    @Column(name = "PaymentProvider", length = 100)
    private String paymentProvider;

    @Column(name = "PaymentDate")
    private Instant paymentDate;

    @Column(name = "Amount")
    private Float amount;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "CreatedAt")
    private Instant createdAt;

    @Column(name = "UpdatedAt")
    private Instant updatedAt;

}