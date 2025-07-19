package com.phuch.fieldfind.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "paymenttype")
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TypeID", nullable = false)
    private Integer id;

    @Column(name = "TypeName", length = 100)
    private String typeName;

    @OneToOne(mappedBy = "paymentTypeID")
    private Payment payment;

}