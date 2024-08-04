package oop.advancedconceptsdesignthinking.banksystem;

public interface Account {
    int getAccountNumber();
    double getBalance();
    boolean verifyPin(String pin);
    void deposit(double amount);
    boolean withdraw(double amount);
    void changePin(String oldPin, String newPin);
}
