package com.kl.avaliacaoAttornatus.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String zipCode;
    private String number;
    private String city;

    private Boolean mainAddress;
    @Setter(AccessLevel.NONE)
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Address() {
    }

    public Address(Long id, String street, String zipCode, String number, String city, Boolean mainAddress) {
        this.id = id;
        this.street = street;
        this.zipCode = zipCode;
        this.number = number;
        this.city = city;
        this.mainAddress = mainAddress;
    }
}
