package br.senai.sc.supertrunfofrutas.business.repository;

import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person findByName(String name);
}
