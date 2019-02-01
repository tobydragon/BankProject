package edu.ithaca.dragon.bank;

public class BankMain {

    public static void main (String[] args){
        //TODO load CentralBank from file
        CentralBank centralBank = new CentralBank();
        new BankCombinedUI(centralBank);
    }
}
