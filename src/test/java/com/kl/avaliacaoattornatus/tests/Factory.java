package com.kl.avaliacaoattornatus.tests;

import com.kl.avaliacaoattornatus.dto.AddressDTO;
import com.kl.avaliacaoattornatus.dto.PersonDTO;
import com.kl.avaliacaoattornatus.entities.Address;
import com.kl.avaliacaoattornatus.entities.Person;

import java.time.LocalDate;

public class Factory {
    public static Person createPerson() {
        LocalDate birthDate = LocalDate.ofEpochDay(1971 - 12 - 28);
        return new Person(1L, "Elon Musk", birthDate);
    }

    public static PersonDTO createPersonDTO() {
        Person person = createPerson();
        return new PersonDTO(person);
    }

    public static Address createAddress() {
        return new Address(1L, "Rua Amaral", "86805900", "415", "Maringá", true, createPerson());
    }

    public static AddressDTO createAddressDTO() {
        Address address = createAddress();
        return new AddressDTO(address);
    }
}
