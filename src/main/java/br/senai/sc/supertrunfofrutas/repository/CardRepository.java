package br.senai.sc.supertrunfofrutas.repository;

import br.senai.sc.supertrunfofrutas.model.entity.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

    Page<Card> findAll(Pageable pageable);

}
