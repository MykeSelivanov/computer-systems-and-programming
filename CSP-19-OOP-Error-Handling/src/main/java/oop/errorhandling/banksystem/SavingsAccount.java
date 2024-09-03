package oop.errorhandling.banksystem;

public class SavingsAccount extends AbstractAccount {
    private double transactionLimit;

    public SavingsAccount() {
        super();
        this.transactionLimit = 0.0;
    }

    public SavingsAccount(int accountNumber, String pin, double transactionLimit) {
        super(accountNumber, pin);
        this.transactionLimit = transactionLimit;
    }

    public SavingsAccount(SavingsAccount account) {
        super(account);
        this.transactionLimit = account.transactionLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= getBalance() && amount <= transactionLimit) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn: " + amount + ". New balance: " + getBalance());
            return true;
        } else {
            System.out.println("Insufficient funds, invalid amount, or exceeds transaction limit.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount " + super.toString() + ", Transaction Limit: { " + transactionLimit + " }";
    }
}
