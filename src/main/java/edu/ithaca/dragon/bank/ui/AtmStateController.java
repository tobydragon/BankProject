package edu.ithaca.dragon.bank.ui;

public class AtmStateController {
    AtmView atmView;

    public AtmStateController(AtmView atmView) {
        this.atmView = atmView;
    }

    public void login(String acctId){
        atmView.moveToAccountView(acctId);
    }
}
