package br.senai.sc.supertrunfofrutas.business.repository;

import br.senai.sc.supertrunfofrutas.business.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
