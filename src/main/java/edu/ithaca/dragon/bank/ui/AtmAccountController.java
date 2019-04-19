package edu.ithaca.dragon.bank.ui;

import edu.ithaca.dragon.bank.AtmAPI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtmAccountController implements ActionListener {
    public static final String DEPOSIT = "Deposit";
    public static final String WITHDRAW = "Withdraw";


    private AtmAccountView atmAccountView;
    private AtmAPI atmApi;
    private String acctId;

    public AtmAccountController(AtmAccountView atmAccountView, AtmAPI atmApi, String acctId) {
        this.atmAccountView = atmAccountView;
        this.atmApi = atmApi;
        this.acctId = acctId;
    }

    public void changeBalance(String actionCommand, String amountStr){

        try{
            double amount = Double.valueOf(amountStr);
            if (amount > 0) {
                if (DEPOSIT.equals(actionCommand)) {
                    atmApi.deposit(acctId, amount);
                } else if (WITHDRAW.equals(actionCommand)) {
                    if (atmApi.checkBalance(acctId) >= amount) {
                        atmApi.withdraw(acctId, amount);
                    }
                    else {
                        atmAccountView.showMessage("Cannot withdraw more than current account balance");
                    }
                } else {
                    throw new RuntimeException("Unrecognized action");
                }
            }
            else {
                atmAccountView.showMessage("Must enter only positive numbers");
            }
        }
        catch (NumberFormatException numberFormatException){
            atmAccountView.showMessage("Must enter only numeric values");
        }
        atmAccountView.updateView();
    }

    public String checkBalance(){
        return String.valueOf(atmApi.checkBalance(acctId));
    }

    public boolean canWithdraw(){
        return  atmApi.checkBalance(acctId) > 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        changeBalance(e.getActionCommand(), atmAccountView.getAmount());
    }


}
