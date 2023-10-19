package br.senai.sc.supertrunfofrutas.security.model;

import br.senai.sc.supertrunfofrutas.business.model.entity.Person;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
public class User implements UserDetails {

    private Person person;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public User(Person person) {
        this.person = person;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }

    public String getUsername() {
        return person.getName();
    }

    public String getPassword() {
        return person.getPassword();
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return person.getAuthorities();
    }
}
