package edu.ithaca.dragon.bank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CentralBank {

    Map<String, BankAccount> idToAccountMap;

    //Makes a private copy of all accounts into a map
    public CentralBank(List<BankAccount> accounts){
        idToAccountMap = new HashMap<>();
        for (BankAccount account : accounts){
            idToAccountMap.put(account.getEmail(), new BankAccount(account));
        }
    }

    public CentralBank(){
        idToAccountMap = new HashMap<>();
    }

    public double checkBalance(String acctId) {
        return idToAccountMap.get(acctId).getBalance();
    }

    public void withdraw(String acctId, double amount) {
        idToAccountMap.get(acctId).withdraw(amount);
    }

    public void deposit(String acctId, double amount) {
        idToAccountMap.get(acctId).deposit(amount);
    }

    public void createAccount(String email, double startingBalance) {
        //TODO
    }

    public void closeAccount(String acctId){
        //TODO
    }

    public boolean isAccountIdValid(String acctId) {
        return idToAccountMap.containsKey(acctId);
    }
}
