package edu.ithaca.dragon.bank;

public class AtmAPI {

    protected CentralBank centralBank;

    public AtmAPI(CentralBank centralBank){
        this.centralBank = centralBank;
    }

    public double checkBalance(String acctId){
        return centralBank.checkBalance(acctId);
    }

    public void withdraw(String acctId, double amount){
        centralBank.withdraw(acctId, amount);
    }

    public void deposit(String acctId, double amount){
        centralBank.deposit(acctId, amount);
    }

    public boolean isAccountIdValid(String acctId){
        return centralBank.isAccountIdValid(acctId);
    }
}
