package oop.testing.banksystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User testUser;

    @BeforeEach
    @DisplayName("UserTest set up")
    void setUp() {
        testUser = new User("Myke Smith", "123test");
    }

    @Test
    @DisplayName("Get id")
    void getId() {
        assertEquals("123test", testUser.getId());
    }

    @Test
    @DisplayName("Add account")
    void addAccount() {
        Account testAccount = new CheckingAccount(1001, "123test");
        testUser.addAccount(testAccount);

        Account retrievedAccount = testUser.getAccount(1001);
        assertNotNull(retrievedAccount);
        assertEquals(1001, retrievedAccount.getAccountNumber());
    }

    @Test
    @DisplayName("Get account")
    void getAccount() {
        Account account1 = new CheckingAccount(1001, "1234");
        Account account2 = new SavingsAccount(1002, "5678", 1000);
        testUser.addAccount(account1);
        testUser.addAccount(account2);

        assertEquals(account1, testUser.getAccount(1001), "Should retrieve account with number 1001");
        assertEquals(account2, testUser.getAccount(1002), "Should retrieve account with number 1002");

        assertNull(testUser.getAccount(9999), "Should return null for a non-existent account number");
    }
}