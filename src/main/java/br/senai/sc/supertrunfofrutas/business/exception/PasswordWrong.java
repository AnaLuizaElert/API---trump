package br.senai.sc.supertrunfofrutas.business.exception;

public class PasswordWrong extends BaseException{
    public PasswordWrong(){
        super("The field current password is wrong!");
    }
}
