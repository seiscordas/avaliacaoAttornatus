package com.kl.avaliacaoAttornatus.resources;

import com.kl.avaliacaoAttornatus.dto.PersonDTO;
import com.kl.avaliacaoAttornatus.entities.Person;
import com.kl.avaliacaoAttornatus.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/persons")
public class PersonResource {
    @Autowired
    private PersonService service;

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findAll(){
        List<PersonDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id){
        PersonDTO personDTO = service.findById(id);
        return ResponseEntity.ok().body(personDTO);
    }
}
