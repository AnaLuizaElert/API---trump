package br.senai.sc.supertrunfofrutas.util;

import br.senai.sc.supertrunfofrutas.business.model.entity.Player;
import br.senai.sc.supertrunfofrutas.security.model.User;
import br.senai.sc.supertrunfofrutas.security.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class DBUtil {

    private UserRepository repository;

    @PostConstruct
    public void fillDB(){
        repository.deleteAll();

        Player player = new Player();
        player.setId(1);
        player.setUsername("admin");
        player.setPoints(1);
        player.setQtyVitories(0);
        player.setQtyLosses(0);

        User user = new User();
        user.setPlayer(player);
        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);
        user.setAuthorities(new ArrayList<>());

        repository.save(user);
    }
}
