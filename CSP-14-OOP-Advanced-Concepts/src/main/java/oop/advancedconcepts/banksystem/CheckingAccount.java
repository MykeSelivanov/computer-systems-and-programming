package oop.advancedconcepts.banksystem;

public class CheckingAccount extends Account{
    public CheckingAccount() {
        super();
    }

    public CheckingAccount(int accountNumber, String pin) {
        super(accountNumber, pin);
    }

    public CheckingAccount(CheckingAccount account) {
        super(account);
    }

    @Override
    public String toString() {
        return "CheckingAccount " + super.toString();
    }
}
