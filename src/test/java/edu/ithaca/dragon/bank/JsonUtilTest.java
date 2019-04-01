package edu.ithaca.dragon.bank;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonUtilTest {

    @Test
    void bankAccountFromJsonFileTest()throws IOException {
        //read in and check that all information is still there in the new object
        BankAccount readIn = JsonUtil.fromJsonFile("src/test/resources/SampleBankAccount.json", BankAccount.class);
        assertEquals("c@d.com", readIn.getEmail());
        assertEquals(200.05, readIn.getBalance());

        //check that reading from a bad path throws an IOException
        assertThrows(IOException.class, ()-> JsonUtil.fromJsonFile("badPath.json", BankAccount.class));
    }

    @Test
    void bankAccountToAndFromJsonFileTest() throws IOException {
        //write out and check that it is there
        BankAccount toWriteOut = new BankAccount("a@b.com", 100);
        JsonUtil.toJsonFile("src/test/resources/bankAccountToAndFromJsonFileTest.json", toWriteOut);
        assertTrue(new File("src/test/resources/bankAccountToAndFromJsonFileTest.json").exists());

        //read in and check that all information is still there in the new object
        BankAccount readIn = JsonUtil.fromJsonFile("src/test/resources/bankAccountToAndFromJsonFileTest.json", BankAccount.class);
        assertEquals(toWriteOut.getEmail(), readIn.getEmail());
        assertEquals(toWriteOut.getBalance(), readIn.getBalance());

        assertTrue(new File("src/test/resources/bankAccountToAndFromJsonFileTest.json").delete());
    }

    @Test
    void bankAccountListFromJsonFileTest()throws IOException {
        //read in and check that all information is still there in the new object
        List<BankAccount> readIn = JsonUtil.listFromJsonFile("src/test/resources/SampleBankAccountList.json", BankAccount.class);
        assertEquals(4, readIn.size());
        //check some of the data
        assertEquals(500, readIn.get(0).getBalance(), 0.00001);
        assertEquals("alice@be.ca", readIn.get(1).getEmail());
        assertEquals(1234567.89, readIn.get(2).getBalance(), 0.00001);
        assertEquals("a.bc.d@xyz.edu", readIn.get(3).getEmail());

        //check that reading from a bad path throws an IOException
        assertThrows(IOException.class, ()-> JsonUtil.fromJsonFile("badPath.json", BankAccount.class));
    }

    @Test
    void bankAccountListToAndFromJsonFileTest() throws IOException {
        //write out and check that it is there
        List<BankAccount> toWriteOut = Arrays.asList(
                new BankAccount("bob@roadrunner.com", 500),
                new BankAccount("alice@be.ca", 100.05),
                new BankAccount("a@b.com", 1234567.89),
                new BankAccount("a.bc.d@xyz.edu", 0.35)
        );
        JsonUtil.toJsonFile("src/test/resources/bankAccountListToAndFromJsonFileTest.json", toWriteOut);
        assertTrue(new File("src/test/resources/bankAccountListToAndFromJsonFileTest.json").exists());

        //read in and check that all information is still there in the new object
        List<BankAccount> readIn = JsonUtil.listFromJsonFile("src/test/resources/bankAccountListToAndFromJsonFileTest.json", BankAccount.class);
        assertEquals(toWriteOut.size(), readIn.size());
        for (int i=0; i< readIn.size(); i++) {
            assertEquals(toWriteOut.get(i).getEmail(), readIn.get(i).getEmail());
            assertEquals(toWriteOut.get(i).getBalance(), readIn.get(i).getBalance());
        }

        assertTrue(new File("src/test/resources/bankAccountListToAndFromJsonFileTest.json").delete());
    }

    @Test
    void savingsAccountToAndFromJsonFileTest() throws IOException {
        //write out and check that it is there
        SavingsAccount toWriteOut = new SavingsAccount("a@b.com", 100, 0.02);
        JsonUtil.toJsonFile("src/test/resources/savingsAccountToAndFromJsonFileTest.json", toWriteOut);
        assertTrue(new File("src/test/resources/savingsAccountToAndFromJsonFileTest.json").exists());

        //read in and check that all information is still there in the new object
        SavingsAccount readIn = JsonUtil.fromJsonFile("src/test/resources/savingsAccountToAndFromJsonFileTest.json", SavingsAccount.class);
        assertEquals(toWriteOut.getEmail(), readIn.getEmail());
        assertEquals(toWriteOut.getBalance(), readIn.getBalance());
        assertEquals(toWriteOut.getInterestRate(),  readIn.getInterestRate());

        assertTrue(new File("src/test/resources/savingsAccountToAndFromJsonFileTest.json").delete());

    }
}