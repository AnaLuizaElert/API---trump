package br.senai.sc.supertrunfofrutas.business.exception;

public class CardNotFound extends BaseException{
    public CardNotFound(){
        super("Card was not found!");
    }
}
