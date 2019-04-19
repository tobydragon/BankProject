package edu.ithaca.dragon.bank.ui;

import edu.ithaca.dragon.bank.AtmAPI;
import edu.ithaca.dragon.bank.BankAccount;
import edu.ithaca.dragon.bank.CentralBank;
import edu.ithaca.dragon.bank.JsonUtil;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class AtmLoginView extends JPanel {

    private JTextArea emailEntryBox;

    public AtmLoginView(AtmAPI atmAPI, AtmStateController atmStateController){
        AtmLoginController atmLoginController = new AtmLoginController(this, atmAPI, atmStateController);

        JLabel emailLabel = new JLabel("Email:");
        emailEntryBox = new JTextArea(1, 15);
        JButton loginButton = new JButton(AtmLoginController.LOG_IN);
        loginButton.setActionCommand(AtmLoginController.LOG_IN);
        loginButton.addActionListener(atmLoginController);

        this.setLayout(new FlowLayout());
        this.add(emailLabel);
        this.add(emailEntryBox);
        this.add(loginButton);

    }

    public String getEmailEntered(){
        return emailEntryBox.getText();
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
}
