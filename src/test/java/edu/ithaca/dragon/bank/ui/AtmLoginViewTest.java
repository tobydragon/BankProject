package edu.ithaca.dragon.bank.ui;

import edu.ithaca.dragon.bank.*;

import java.io.IOException;
import java.util.List;

public class AtmLoginViewTest {

    public static void main(String[] args) throws IOException {
        List<BankAccount> testAccounts = JsonUtil.listFromJsonFile("src/test/resources/SampleBankAccountList.json", BankAccount.class);
        AtmAPI atmAPI = new AtmAPI(new CentralBank(testAccounts));
        AtmView atmView = new AtmView(atmAPI);
        AtmStateController atmStateController = new AtmStateController(atmView);
        SwingTestUtil.showPanelInTestFrame(new AtmLoginView( atmAPI, atmStateController));
    }
}
