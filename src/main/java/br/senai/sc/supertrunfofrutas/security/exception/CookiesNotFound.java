package br.senai.sc.supertrunfofrutas.security.exception;

public class CookiesNotFound extends RuntimeException{
    public CookiesNotFound(){
        super("Cookie não encontrado");
    }
}
