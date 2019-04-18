package edu.ithaca.dragon.bank.gui;

import edu.ithaca.dragon.bank.AtmAPI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtmLoggedInController implements ActionListener {
    public static final String DEPOSIT = "Deposit";
    public static final String WITHDRAW = "Withdraw";


    AtmLoggedInView atmLoggedInView;
    AtmAPI atmApi;
    String acctId;

    public AtmLoggedInController(AtmLoggedInView atmLoggedInView, AtmAPI atmApi, String acctId) {
        this.atmLoggedInView = atmLoggedInView;
        this.atmApi = atmApi;
        this.acctId = acctId;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String amountStr = atmLoggedInView.getAmount();
        try{
            double amount = Double.valueOf(amountStr);
            if (amount > 0) {
                if (DEPOSIT.equals(e.getActionCommand())) {
                    atmApi.deposit(acctId, Double.valueOf(atmLoggedInView.getAmount()));
                } else if (WITHDRAW.equals(e.getActionCommand())) {
                    if (atmApi.checkBalance(acctId) >= amount) {
                        atmApi.withdraw(acctId, Double.valueOf(atmLoggedInView.getAmount()));
                    }
                    else {
                        atmLoggedInView.showMessage("Cannot withdraw more than current account balance");
                    }
                } else {
                    throw new RuntimeException("Unrecognized action");
                }
            }
            else {
                atmLoggedInView.showMessage("Must enter only positive numbers");
            }
        }
        catch (NumberFormatException numberFormatException){
            atmLoggedInView.showMessage("Must enter only numeric values");
        }
        atmLoggedInView.updateView();

    }

    public String checkBalance(){
        return String.valueOf(atmApi.checkBalance(acctId));
    }


}
