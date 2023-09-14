package br.senai.sc.supertrunfofrutas.util;

import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
import br.senai.sc.supertrunfofrutas.business.repository.PersonRepository;
import br.senai.sc.supertrunfofrutas.security.model.User;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DBUtil {

    private PersonRepository personRepository;

    @PostConstruct
    public void fillDB(){
        personRepository.deleteAll();

        /*ADMIN*/
        Person personAdmin = new Person();
        personAdmin.setName("admin");
        personAdmin.setPassword(new BCryptPasswordEncoder().encode("admin"));

        personRepository.save(personAdmin);

        /*ADMIN*/
//        User userAdmin = new User();
//        userAdmin.setPerson(personAdmin);
//        userAdmin.setAccountNonExpired(true);
//        userAdmin.setAccountNonLocked(true);
//        userAdmin.setCredentialsNonExpired(true);
//        userAdmin.setAuthorities(null);
//        userAdmin.setEnabled(true);

    }
}
