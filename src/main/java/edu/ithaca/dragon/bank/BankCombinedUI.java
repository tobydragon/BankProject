package edu.ithaca.dragon.bank;

import java.util.Scanner;

public class BankCombinedUI {

    Scanner scanner;

    public BankCombinedUI(CentralBank centralBank){
        scanner = new Scanner(System.in);
        UiMode mode = getModeFromUser();
        if (mode == UiMode.atm) {
            runAtmUI(new AtmAPI(centralBank));
        }
        else if (mode == UiMode.teller){
            runTellerUI(new TellerAPI(centralBank));
        }
        else {
            throw new RuntimeException("UI entered invalid mode.");
        }
    }

    public UiMode getModeFromUser(){
        System.out.print("Enter mode:");
        String potentialMode = scanner.nextLine();
        while (!isValidMode(potentialMode)){
            System.out.print("\nInvalid Mode, please try again:");
            potentialMode = scanner.nextLine();
        }
        return UiMode.valueOf(potentialMode);
    }

    public static boolean isValidMode(String potentialMode){
        //TODO
        return true;
    }

    public void runAtmUI(AtmAPI atmAPI){
        AtmUi atmUi = new AtmUi(atmAPI);
        atmUi.run();
    }

    public void runTellerUI(TellerAPI tellerAPI){
        TellerUi tellerUi = new TellerUi(tellerAPI);
        tellerUi.run();
    }


}
