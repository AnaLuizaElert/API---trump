package br.senai.sc.supertrunfofrutas.business.repository;

import br.senai.sc.supertrunfofrutas.business.model.entity.Card;
import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    Page<Card> findAll(Pageable pageable);

    Optional<Card> findByName(String name);
}
