package oop.testing.banksystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SavingsAccountTest {

    private SavingsAccount testSavingsAccount;

    @BeforeEach
    void setUp() {
        testSavingsAccount = new SavingsAccount(1234, "test!#$pin", 3000);
    }

    @Test
    @DisplayName("Should return correct account number")
    void getAccountNumber() {
        assertEquals(1234, testSavingsAccount.getAccountNumber(), "Account number should be 1234");
    }

    @Test
    @DisplayName("Should return initial balance of 0.0")
    void getBalance() {
        assertEquals(0.0, testSavingsAccount.getBalance(), "Initial balance should be 0.0");
    }

    @Test
    @DisplayName("Should set and return the correct balance")
    void setBalance() {
        testSavingsAccount.setBalance(200.0);
        assertEquals(200.0, testSavingsAccount.getBalance(), "Balance should be set to 200.0");
    }

    @Test
    @DisplayName("Should verify correct PIN and reject incorrect PIN")
    void verifyPin() {
        assertTrue(testSavingsAccount.verifyPin("test!#$pin"), "PIN should be verified correctly");
        assertFalse(testSavingsAccount.verifyPin("wrongPIN"), "PIN verification should fail for incorrect PIN");
    }

    @Test
    @DisplayName("Should deposit a valid amount and update balance")
    void deposit() {
        testSavingsAccount.deposit(500.0);
        assertEquals(500.0, testSavingsAccount.getBalance(), "Balance should be 500.0 after deposit");

        testSavingsAccount.deposit(-100.0);  // Invalid deposit
        assertEquals(500.0, testSavingsAccount.getBalance(), "Balance should remain 500.0 after invalid deposit");
    }

    @Test
    @DisplayName("Should withdraw a valid amount within limit and reject invalid withdrawal")
    void withdraw() {
        testSavingsAccount.setBalance(2000.0);

        assertTrue(testSavingsAccount.withdraw(1000.0), "Withdrawal should be successful");
        assertEquals(1000.0, testSavingsAccount.getBalance(), "Balance should be 1000.0 after withdrawal");

        assertFalse(testSavingsAccount.withdraw(5000.0), "Withdrawal should fail due to exceeding transaction limit");
        assertEquals(1000.0, testSavingsAccount.getBalance(), "Balance should remain 1000.0 after failed withdrawal");

        assertFalse(testSavingsAccount.withdraw(0.0), "Withdrawal should fail due to invalid amount");
        assertFalse(testSavingsAccount.withdraw(-100.0), "Withdrawal should fail due to negative amount");
    }

    @Test
    @DisplayName("Should change PIN with correct old PIN and reject incorrect old PIN")
    void changePin() {
        testSavingsAccount.changePin("test!#$pin", "newPIN123");
        assertTrue(testSavingsAccount.verifyPin("newPIN123"), "PIN should be changed successfully");

        testSavingsAccount.changePin("wrongPIN", "anotherPIN");
        assertTrue(testSavingsAccount.verifyPin("newPIN123"), "PIN should remain unchanged after incorrect old PIN");
    }
}