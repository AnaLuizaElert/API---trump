package br.senai.sc.supertrunfofrutas.business.repository;

import br.senai.sc.supertrunfofrutas.business.model.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
