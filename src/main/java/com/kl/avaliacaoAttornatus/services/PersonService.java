package com.kl.avaliacaoAttornatus.services;

import com.kl.avaliacaoAttornatus.dto.PersonDTO;
import com.kl.avaliacaoAttornatus.entities.Person;
import com.kl.avaliacaoAttornatus.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    @Transactional(readOnly = true)
    public List<PersonDTO> findAll() {
        List<Person> list = repository.findAll();
        return list.stream().map(PersonDTO::new).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public PersonDTO findById(Long id) {
        Optional<Person> obj = repository.findById(id);
        Person entity = obj.get();
        return new PersonDTO(entity);
    }
}
