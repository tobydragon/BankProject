package edu.ithaca.dragon.bank.ui;

import edu.ithaca.dragon.bank.AtmAPI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtmLoginController implements ActionListener {

    public static final String LOG_IN = "Login";

    private AtmAPI atmAPI;
    private AtmLoginView atmLoginView;
    private AtmStateController atmStateController;

    public AtmLoginController(AtmLoginView atmLoginView, AtmAPI atmAPI, AtmStateController atmStateController) {
        this.atmLoginView = atmLoginView;
        this.atmAPI = atmAPI;
        this.atmStateController = atmStateController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (LOG_IN.equals(e.getActionCommand())){
            attemptLogin(atmLoginView.getEmailEntered());
        }
        else {
            throw new RuntimeException("Unrecognized action");
        }
    }

    public void attemptLogin(String email){
        if (atmAPI.isAccountIdValid(email)){
            atmStateController.login(email);
        }
        else {
            atmLoginView.showMessage("Invalid email, please try again");
        }
    }
}
