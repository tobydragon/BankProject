package edu.ithaca.dragon.bank;

public class BankMain {

    public static void main (String[] args){
        CentralBank centralBank = new CentralBank();
        new BankCombinedUI(centralBank);
    }
}
