package br.senai.sc.supertrunfofrutas.repository;

import br.senai.sc.supertrunfofrutas.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
