package br.senai.sc.supertrunfofrutas.business.model.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Profile implements GrantedAuthority {
    ADMIN, USER;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
