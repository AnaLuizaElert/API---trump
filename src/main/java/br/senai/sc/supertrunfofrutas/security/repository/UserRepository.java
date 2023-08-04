package br.senai.sc.supertrunfofrutas.security.repository;

import br.senai.sc.supertrunfofrutas.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByPlayer_Username(String user);

}
