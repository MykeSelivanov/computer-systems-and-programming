package oop.testing.banksystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankSystemTest {

    private BankSystem testBankSystem;

    @BeforeEach
    void setUp() {
        testBankSystem = new BankSystem();
    }

    @AfterEach
    void tearDown() {
        testBankSystem = null;
    }

    @Test
    @DisplayName("Should add a new user to the system")
    void addUser() {
        testBankSystem.addUser("John Doe", "12345");
        assertNotNull(testBankSystem.getUser("12345"), "User should be added successfully");
    }

    @Test
    @DisplayName("Should not add a user if the user ID already exists")
    void addUser_DuplicateId() {
        testBankSystem.addUser("John Doe", "12345");
        testBankSystem.addUser("Jane Smith", "12345");
        assertEquals("John Doe", testBankSystem.getUser("12345").getName(), "Duplicate user ID should not be allowed");
    }

    @Test
    @DisplayName("Should retrieve a user by their ID")
    void getUser() {
        testBankSystem.addUser("John Doe", "12345");
        User retrievedUser = testBankSystem.getUser("12345");
        assertNotNull(retrievedUser, "User should be retrieved successfully");
        assertEquals("12345", retrievedUser.getId(), "Retrieved user ID should match");
    }

    @Test
    @DisplayName("Should return null if user does not exist")
    void getUser_NotFound() {
        User retrievedUser = testBankSystem.getUser("67890");
        assertNull(retrievedUser, "Non-existing user ID should return null");
    }

    @Test
    @DisplayName("Should create a Savings account for a valid user")
    void createSavingsAccount() {
        testBankSystem.addUser("John Doe", "12345");
        testBankSystem.createAccount("12345", 1111, "mypin", true, 5000.0);

        User user = testBankSystem.getUser("12345");
        assertNotNull(user.getAccount(1111), "Account should be created successfully");
        assertInstanceOf(SavingsAccount.class, user.getAccount(1111), "Account type should be SavingsAccount");
    }

    @Test
    @DisplayName("Should create a Checking account for a valid user")
    void createCheckingAccount() {
        testBankSystem.addUser("Jane Doe", "67890");
        testBankSystem.createAccount("67890", 2222, "mypin", false, 0.0);

        User user = testBankSystem.getUser("67890");
        assertNotNull(user.getAccount(2222), "Account should be created successfully");
        assertInstanceOf(CheckingAccount.class, user.getAccount(2222), "Account type should be CheckingAccount");
    }
}