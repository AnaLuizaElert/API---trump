package br.senai.sc.supertrunfofrutas.business.exception;

public class PersonNotFound extends BaseException{
    public PersonNotFound(){
        super("Person was not found!");
    }
}
