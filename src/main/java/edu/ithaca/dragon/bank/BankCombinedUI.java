package edu.ithaca.dragon.bank;

import java.util.Scanner;

public class BankCombinedUI {

    CentralBank centralBank;
    Scanner scanner;

    public BankCombinedUI(CentralBank centralBank){
        this.centralBank = centralBank;
        scanner = new Scanner(System.in);
        String mode = getModeFromUser();
        if ("atm".equals(mode)) {
            runAtmUI();
        }
        else if ("teller".equals(mode)){
            runTellerUI();
        }
    }

    public String getModeFromUser(){
        System.out.print("Enter mode:");
        String potentialMode = scanner.nextLine();
        while (!isValidMode(potentialMode)){
            System.out.print("\nInvalid Mode, please try again:");
            potentialMode = scanner.nextLine();
        }
        return potentialMode;
    }

    public static boolean isValidMode(String potentialMode){
        //TODO
        return true;
    }

    public void runAtmUI(){
        AtmAPI atmAPI = new AtmAPI(centralBank);
        //TODO make ATM interaction
    }

    public void runTellerUI(){
        TellerAPI tellerAPI = new TellerAPI(centralBank);
        //TODO make teller interaction
    }


}
