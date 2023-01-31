package com.kl.avaliacaoattornatus.repositories;

import com.kl.avaliacaoattornatus.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
