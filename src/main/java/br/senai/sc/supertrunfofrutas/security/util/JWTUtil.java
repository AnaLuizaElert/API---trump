package br.senai.sc.supertrunfofrutas.security.util;

import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
import br.senai.sc.supertrunfofrutas.business.repository.PersonRepository;
import br.senai.sc.supertrunfofrutas.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

@Component
public class JWTUtil {

    private static final String STRONGPASSWORD = "c127a7b6adb013a5ff879ae71afa62afa4b4ceb72afaa54711dbcde67b6dc325";
    private static PersonRepository personRepository;

    @Autowired
    JWTUtil(PersonRepository personRepository){JWTUtil.personRepository = personRepository;}

    public static String generateToken(User user){
        Algorithm algorithm = Algorithm.HMAC256(STRONGPASSWORD);

        return JWT.create()
                .withIssuer("WEG")
                .withSubject(user.getPerson().getId().toString())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(new Date().getTime() + 18000000))
                .sign(algorithm);
    }

    public static User getUser(String token){
        String id = JWT.decode(token).getSubject();
        Integer idInt = Integer.parseInt(id);
        Person person = personRepository.findById(idInt).orElseThrow();
        return new User(person);
    }

}
