package com.kl.avaliacaoAttornatus.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;

    @Setter(AccessLevel.NONE)
    @OneToMany(targetEntity=Address.class, mappedBy="person", fetch=FetchType.EAGER)
    private List<Address> addresses = new ArrayList<>();

    public Person() {
    }

    public Person(Long id, String name, LocalDate birthDate, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.addresses = addresses;
    }
}
