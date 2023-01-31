package com.kl.avaliacaoattornatus.repositories;

import com.kl.avaliacaoattornatus.entities.Address;
import com.kl.avaliacaoattornatus.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByPerson(Person person);
}
