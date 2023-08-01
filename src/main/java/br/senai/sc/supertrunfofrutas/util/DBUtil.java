package br.senai.sc.supertrunfofrutas.util;

import br.senai.sc.supertrunfofrutas.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DBUtil {

    private UserRepository userRepository;

    @PostConstruct
    public void fillDB(){

    }
}
