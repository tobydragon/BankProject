package edu.ithaca.dragon.bank;

import edu.ithaca.dragon.bank.ui.AtmAccountView;

import javax.swing.*;
import java.util.List;

public class SwingTestUtil {

    public static void showPanelInTestFrame(JPanel panelToTest){
        JFrame testFrame = new JFrame();
        testFrame.add(panelToTest);
        testFrame.pack();
        testFrame.setVisible(true);
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
