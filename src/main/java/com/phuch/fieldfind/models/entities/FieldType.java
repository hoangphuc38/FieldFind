package com.phuch.fieldfind.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "fieldtype")
public class FieldType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FieldTypeID", nullable = false)
    private Integer id;

    @Column(name = "TypeName", length = 100)
    private String typeName;

    @Column(name = "PricePerHour")
    private Float pricePerHour;

    @OneToMany(mappedBy = "fieldType")
    private Set<Field> fields = new LinkedHashSet<>();

}