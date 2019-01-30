package edu.ithaca.dragon.bank;

public class InsufficientFundsException extends RuntimeException {

    public InsufficientFundsException(String s){
        super(s);
    }

}