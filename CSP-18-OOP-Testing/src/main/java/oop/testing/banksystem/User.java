package oop.testing.banksystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String id;
    private List<Account> accounts;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.accounts = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added: " + account);
    }

    public Account getAccount(int accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null;
    }

    public void listAccounts() {
        System.out.println("Accounts for " + name + ":");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }
}
