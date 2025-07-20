package com.phuch.fieldfind.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "invoice", indexes = {
        @Index(name = "index_invoice_bookingID", columnList = "BookingID"),
        @Index(name = "index_invoice_customerName_fieldName", columnList = "CustomerName, FieldName")
}, uniqueConstraints = {
        @UniqueConstraint(name = "BookingID", columnNames = {"BookingID"})
})
public class Invoice {
    @Id
    @Column(name = "InvoiceNumber", nullable = false, length = 100)
    private String invoiceNumber;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BookingID")
    private Booking booking;

    @Column(name = "CustomerName", length = 100)
    private String customerName;

    @Column(name = "CustomerPhone", length = 100)
    private String customerPhone;

    @Column(name = "FieldName", length = 100)
    private String fieldName;

    @Column(name = "FieldAddress", length = 100)
    private String fieldAddress;

    @Column(name = "TotalAmount")
    private Float totalAmount;

    @Column(name = "CreatedAt")
    private Instant createdAt;

}