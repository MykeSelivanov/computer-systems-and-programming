package oop.advancedconcepts.banksystem;

abstract class Account {
    private int accountNumber;
    private double balance;
    private String pin;

    public Account() {
        this.accountNumber = 0;
        this.balance = 0.0;
        this.pin = "";
    }

    public Account(int accountNumber, String pin) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.pin = pin;
    }

    public Account(Account account) {
        this.accountNumber = account.accountNumber;
        this.balance = account.balance;
        this.pin = account.pin;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean verifyPin(String pin) {
        return this.pin.equals(pin);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ". New balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient funds or invalid amount.");
            return false;
        }
    }

    public void changePin(String oldPin, String newPin) {
        if (verifyPin(oldPin)) {
            this.pin = newPin;
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("Invalid old PIN.");
        }
    }

    @Override
    public String toString() {
        return "{ " + "accountNumber=" + accountNumber + ", balance=" + balance + " }";
    }
}
