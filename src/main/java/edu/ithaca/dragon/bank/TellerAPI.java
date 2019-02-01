package edu.ithaca.dragon.bank;

public class TellerAPI extends AtmAPI{

    public TellerAPI(CentralBank centralBank){
        super(centralBank);
    }

    public void createAccount(String email, double startingBalance){
        centralBank.createAccount(email, startingBalance);
    }

    public void closeAccount(String acctId){
        centralBank.closeAccount(acctId);
    }
}
