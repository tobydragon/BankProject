package edu.ithaca.dragon.bank;

public class TellerUi extends AtmUi{
    protected TellerAPI tellerAPI;

    public TellerUi(TellerAPI tellerAPI){
        super(tellerAPI);
        this.tellerAPI = tellerAPI;
    }

    public void run(){
        System.out.println("Starting Teller UI");
        //TODO
        System.out.println("Ending Teller UI");
    }

    //TODO write methods that interact with the user and make API calls, started from constructor
}
