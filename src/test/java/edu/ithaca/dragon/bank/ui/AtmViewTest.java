package edu.ithaca.dragon.bank.ui;

import edu.ithaca.dragon.bank.*;

import java.io.IOException;
import java.util.List;

public class AtmViewTest {

    public static void main(String[] args) throws IOException {
        List<BankAccount> testAccounts = JsonUtil.listFromJsonFile("src/test/resources/SampleBankAccountList.json", BankAccount.class);
        SwingTestUtil.showPanelInTestFrame(new AtmView( new AtmAPI(new CentralBank(testAccounts))));
    }
}