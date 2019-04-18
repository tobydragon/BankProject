package edu.ithaca.dragon.bank;

import java.util.List;
import java.util.Map;

public class CentralBank {

    Map<String, BankAccount> idToAccountMap;

    //Makes a private copy of all accounts into a map
    CentralBank(List<BankAccount> accounts){
        for (BankAccount account : accounts){
            idToAccountMap.put(account.getEmail(), new BankAccount(account));
        }
    }


    public double checkBalance(String acctId) {
        //TODO
        return -123456;
    }

    public void withdraw(String acctId, double amount) {
        //TODO
    }

    public void deposit(String acctId, double amount) {
        //TODO
    }

    public void createAccount(String email, double startingBalance) {
        //TODO
    }

    public void closeAccount(String acctId){
        //TODO
    }
}
