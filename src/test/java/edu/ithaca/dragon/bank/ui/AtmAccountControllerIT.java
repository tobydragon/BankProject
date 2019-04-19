package edu.ithaca.dragon.bank.ui;

import edu.ithaca.dragon.bank.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class AtmAccountControllerIT {

    @Test
    public void changeBalanceTest() throws IOException {

        List<BankAccount> testAccounts = JsonUtil.listFromJsonFile("src/test/resources/SampleBankAccountList.json", BankAccount.class);
        AtmAPI atmAPI = new AtmAPI(new CentralBank(testAccounts));
        AtmAccountController atmAccountController = new AtmAccountController(new AtmAccountView("bob@roadrunner.com", atmAPI), atmAPI, "bob@roadrunner.com");

        atmAccountController.changeBalance(AtmAccountController.DEPOSIT, "500.0");
        assertEquals("1000.0", atmAccountController.checkBalance());
    }
}
