package oop.errorhandling.banksystem;

import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    private Map<String, User> users;

    public BankSystem() {
        users = new HashMap<>();
    }

    public void addUser(String name, String id) {
        if (name == null || id == null) {
            throw new IllegalArgumentException("Name or ID cannot be null");
        }

        if (!users.containsKey(id)) {
            users.put(id, new User(name, id));
            System.out.println("User added: " + name);
        } else {
            System.out.println("User with ID " + id + " already exists.");
        }
    }

    public User getUser(String id) {
        if (id == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        return users.get(id);
    }

    public void createAccount(String userId, int accountNumber, String pin, boolean isSavings, double transactionLimit) throws UserNotFoundException {
        User user = users.get(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found: " + userId);
        }

        Account account;
        if (isSavings) {
            account = new SavingsAccount(accountNumber, pin, transactionLimit);
        } else {
            account = new CheckingAccount(accountNumber, pin);
        }
        user.addAccount(account);
    }
}