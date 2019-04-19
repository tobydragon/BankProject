package edu.ithaca.dragon.bank.ui;

import edu.ithaca.dragon.bank.AtmAPI;

import javax.swing.*;

public class AtmView extends JPanel {

    AtmAPI atmAPI;

    public AtmView(AtmAPI atmAPI){
        this.atmAPI = atmAPI;
        AtmStateController atmStateController = new AtmStateController(this);
        this.add(new AtmLoginView(atmAPI, atmStateController));
    }

    public void moveToAccountView(String acctId){
        this.removeAll();
        this.add(new AtmAccountView(acctId, atmAPI));
        this.revalidate();
        this.repaint();
    }


}
