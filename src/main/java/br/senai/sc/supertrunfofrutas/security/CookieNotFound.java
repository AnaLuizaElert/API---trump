package br.senai.sc.supertrunfofrutas.security;

public class CookieNotFound extends RuntimeException{
    public CookieNotFound(){
        super("Cookie não encontrado!");
    }
}
