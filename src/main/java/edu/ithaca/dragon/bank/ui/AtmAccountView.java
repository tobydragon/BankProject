package edu.ithaca.dragon.bank.ui;

import edu.ithaca.dragon.bank.AtmAPI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class AtmAccountView extends JPanel {
    private AtmAccountController controller;

    //Keep any visualized objects you intend to change as data members
    private JLabel balanceDisplay;
    private JTextArea amountBox;
    private JButton withdrawButton;

    public AtmAccountView(String acctId, AtmAPI atmAPI){
        this.controller = new AtmAccountController(this, atmAPI, acctId);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(createBalanceDisplayPanel());
        this.add(createActionPanel(controller));

        updateView();
    }

    private JPanel createBalanceDisplayPanel(){
        JPanel balanceDisplayPanel = new JPanel();
        balanceDisplayPanel.setLayout(new FlowLayout());

        JLabel balanceLabel = new JLabel("Current Balance:");
        balanceDisplayPanel.add(balanceLabel);

        balanceDisplay = new JLabel();
        balanceDisplayPanel.add(balanceDisplay);

        return balanceDisplayPanel;
    }

    private JPanel createActionPanel(ActionListener controller){
        amountBox = new JTextArea();

        JButton depositButton = new JButton(AtmAccountController.DEPOSIT);
        depositButton.setActionCommand(AtmAccountController.DEPOSIT);
        depositButton.addActionListener(controller);
        JPanel depositPanel = new JPanel();
        depositPanel.add(depositButton);

        withdrawButton = new JButton(AtmAccountController.WITHDRAW);
        withdrawButton.setActionCommand(AtmAccountController.WITHDRAW);
        withdrawButton.addActionListener(controller);
        JPanel withdrawPanel = new JPanel();
        withdrawPanel.add(withdrawButton);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(amountBox, BorderLayout.PAGE_START);
        actionPanel.add(depositPanel,BorderLayout.LINE_START);
        actionPanel.add(withdrawPanel,BorderLayout.LINE_END);

        return actionPanel;
    }

    public void updateView(){
        balanceDisplay.setText(controller.checkBalance());
        if (controller.canWithdraw()){
            withdrawButton.setEnabled(true);
        }
        else {
            withdrawButton.setEnabled(false);
        }
    }

    public String getAmount(){
        return amountBox.getText();
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

}
