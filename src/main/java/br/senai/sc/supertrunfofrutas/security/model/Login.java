package br.senai.sc.supertrunfofrutas.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Login {

    private String username;
    private String password;

}
