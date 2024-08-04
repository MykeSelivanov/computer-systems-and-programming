package oop.advancedconceptsdesignthinking.banksystem;

import java.util.HashMap;
import java.util.Map;

public class BankSystem {
    private Map<String, User> users;

    public BankSystem() {
        users = new HashMap<>();
    }

    public void addUser(String name, String id) {
        if (!users.containsKey(id)) {
            users.put(id, new User(name, id));
            System.out.println("User added: " + name);
        } else {
            System.out.println("User with ID " + id + " already exists.");
        }
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public void createAccount(String userId, int accountNumber, String pin, boolean isSavings, double transactionLimit) {
        User user = users.get(userId);
        if (user != null) {
            Account account;
            if (isSavings) {
                account = new SavingsAccount(accountNumber, pin, transactionLimit);
            } else {
                account = new CheckingAccount(accountNumber, pin);
            }
            user.addAccount(account);
        } else {
            System.out.println("User not found.");
        }
    }
}
