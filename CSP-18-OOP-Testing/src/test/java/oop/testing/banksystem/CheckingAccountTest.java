package oop.testing.banksystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {

    private CheckingAccount testCheckingAccount;

    @BeforeEach
    void setUp() {
        testCheckingAccount = new CheckingAccount(12345, "1234");
    }

    @Test
    @DisplayName("Should return correct account number")
    void getAccountNumber() {
        assertEquals(12345, testCheckingAccount.getAccountNumber(), "Account number should be 12345");
    }

    @Test
    @DisplayName("Should return initial balance of 0.0")
    void getBalance() {
        assertEquals(0.0, testCheckingAccount.getBalance(), "Initial balance should be 0.0");
    }

    @Test
    @DisplayName("Should set and return the correct balance")
    void setBalance() {
        testCheckingAccount.setBalance(100.0);
        assertEquals(100.0, testCheckingAccount.getBalance(), "Balance should be set to 100.0");
    }

    @Test
    @DisplayName("Should verify correct PIN and reject incorrect PIN")
    void verifyPin() {
        assertTrue(testCheckingAccount.verifyPin("1234"), "PIN should be verified correctly");
        assertFalse(testCheckingAccount.verifyPin("0000"), "PIN verification should fail for incorrect PIN");
    }

    @Test
    @DisplayName("Should deposit a valid amount and update balance")
    void deposit() {
        testCheckingAccount.deposit(200.0);
        assertEquals(200.0, testCheckingAccount.getBalance(), "Balance should be 200.0 after deposit");

        // Tes invalid deposit
        testCheckingAccount.deposit(-50.0);
        assertEquals(200.0, testCheckingAccount.getBalance(), "Balance should remain 200.0 after invalid deposit");
    }

    @Test
    @DisplayName("Should withdraw valid amount and reject invalid withdrawal")
    void withdraw() {
        testCheckingAccount.setBalance(300.0);

        assertTrue(testCheckingAccount.withdraw(100.0), "Withdrawal should be successful");
        assertEquals(200.0, testCheckingAccount.getBalance(), "Balance should be 200.0 after withdrawal");

        assertFalse(testCheckingAccount.withdraw(500.0), "Withdrawal should fail due to insufficient funds");
        assertEquals(200.0, testCheckingAccount.getBalance(), "Balance should remain 200.0 after failed withdrawal");

        assertFalse(testCheckingAccount.withdraw(-50.0), "Withdrawal should fail due to invalid amount");
        assertEquals(200.0, testCheckingAccount.getBalance(), "Balance should remain 200.0 after invalid withdrawal");
    }

    @Test
    @DisplayName("Should change PIN with correct old PIN and reject incorrect old PIN")
    void changePin() {
        testCheckingAccount.changePin("1234", "5678");
        assertTrue(testCheckingAccount.verifyPin("5678"), "PIN should be changed successfully");

        testCheckingAccount.changePin("1234", "9999");  // Wrong old PIN
        assertTrue(testCheckingAccount.verifyPin("5678"), "PIN should remain unchanged after incorrect old PIN");
    }
}