package com.kl.avaliacaoAttornatus.dto;

import com.kl.avaliacaoAttornatus.entities.Address;
import com.kl.avaliacaoAttornatus.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class PersonDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private LocalDate birthDate;

    private List<Address> addresses = new ArrayList<>();

    public PersonDTO(Person entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.birthDate = entity.getBirthDate();
    }
}
