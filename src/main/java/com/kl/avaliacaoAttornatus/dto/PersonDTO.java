package com.kl.avaliacaoAttornatus.dto;

import com.kl.avaliacaoAttornatus.entities.Address;
import com.kl.avaliacaoAttornatus.entities.Person;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class PersonDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private LocalDate birthDate;

    private List<Address> addresses = new ArrayList<>();

    public PersonDTO() {
    }

    public PersonDTO(Long id, String name, LocalDate birthDate, List<Address> addresses) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.addresses = addresses;
    }

    public PersonDTO(Person entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.birthDate = entity.getBirthDate();
        this.addresses = entity.getAddresses();
    }
}
