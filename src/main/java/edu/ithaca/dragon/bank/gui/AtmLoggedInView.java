package edu.ithaca.dragon.bank.gui;

import edu.ithaca.dragon.bank.AtmAPI;
import edu.ithaca.dragon.bank.CentralBank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AtmLoggedInView extends JPanel {
    private AtmLoggedInController controller;

    private JLabel balanceDisplay;
    private JTextArea amountBox;
    private JButton depositButton;
    private JButton withdrawButton;

    public AtmLoggedInView(String acctId, AtmAPI atmAPI){
        this.controller = new AtmLoggedInController(this, atmAPI, acctId);

        JLabel balanceLabel = new JLabel("Current Balance:");
        balanceDisplay = new JLabel();


        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.add(balanceLabel);
        this.add(balanceDisplay);

        this.add(createActionPanel(controller));

        updateView();

    }

    private JPanel createActionPanel(ActionListener controller){
        amountBox = new JTextArea();
        depositButton = new JButton(AtmLoggedInController.DEPOSIT);
        depositButton.setActionCommand(AtmLoggedInController.DEPOSIT);
        depositButton.addActionListener(controller);

        withdrawButton = new JButton(AtmLoggedInController.WITHDRAW);
        withdrawButton.setActionCommand(AtmLoggedInController.WITHDRAW);
        withdrawButton.addActionListener(controller);


        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new BorderLayout());
        actionPanel.add(amountBox, BorderLayout.PAGE_START);
        actionPanel.add(depositButton,BorderLayout.LINE_START);
        actionPanel.add(withdrawButton,BorderLayout.LINE_END);

        return actionPanel;
    }

    public void updateView(){
        balanceDisplay.setText(controller.checkBalance());
    }

    public String getAmount(){
        return amountBox.getText();
    }

    public void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args){
        JFrame testFrame = new JFrame();
        testFrame.add(new AtmLoggedInView("custID123", new AtmAPI(new CentralBank())));
        testFrame.pack();
        testFrame.setVisible(true);
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
