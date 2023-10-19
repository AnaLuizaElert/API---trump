package br.senai.sc.supertrunfofrutas.security.exception;

import br.senai.sc.supertrunfofrutas.business.exception.BaseException;

public class CookiesNotFound extends BaseException {
    public CookiesNotFound(){
        super("Cookie não encontrado");
    }
}
