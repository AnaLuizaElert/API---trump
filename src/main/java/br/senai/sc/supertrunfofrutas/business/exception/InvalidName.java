package br.senai.sc.supertrunfofrutas.business.exception;

public class InvalidName extends BaseException{
    public InvalidName(){
        super("This name already exists!");
    }
}
