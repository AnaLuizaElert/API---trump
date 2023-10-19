package br.senai.sc.supertrunfofrutas.security.model;

import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
public class User implements UserDetails {

    private Person person;
    private List authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public User(Person person) {
        this.person = person;
        this.authorities = Collections.emptyList();
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }

    @Override
    public String getPassword() {
        return person.getPassword();
    }

    @Override
    public String getUsername() {
        return person.getName();
    }

}
