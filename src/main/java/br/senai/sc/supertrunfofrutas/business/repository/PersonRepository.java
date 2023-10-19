package br.senai.sc.supertrunfofrutas.business.repository;

import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findByName(String name);

    Person getPersonByName(String name);
}
