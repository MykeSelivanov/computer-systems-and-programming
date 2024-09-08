package oop.ooppractice.classIntro;

public class BalanceImpl implements Balance {
    int balance;

    public BalanceImpl(int balance) {
        this.balance = balance;
    }

    @Override
    public int getCurrentBalance() {
        return balance;
    }

    @Override
    public void setCurrentBalance(int balance) {
        this.balance = balance;
    }
}
