package oop.errorhandling.banksystem;

public interface Account {
    int getAccountNumber();
    double getBalance();
    boolean verifyPin(String pin);
    void deposit(double amount);
    boolean withdraw(double amount) throws InsufficientFundsException;
    void changePin(String oldPin, String newPin) throws InvalidPinException;
}
