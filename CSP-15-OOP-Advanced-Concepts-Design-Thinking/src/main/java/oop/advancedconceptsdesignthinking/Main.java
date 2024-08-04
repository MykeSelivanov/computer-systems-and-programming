package oop.advancedconceptsdesignthinking;

import oop.advancedconceptsdesignthinking.banksystem.Account;
import oop.advancedconceptsdesignthinking.banksystem.BankSystem;
import oop.advancedconceptsdesignthinking.banksystem.CheckingAccount;
import oop.advancedconceptsdesignthinking.banksystem.User;

public class Main {
    public static void main(String[] args) {

        BankSystem bankSystem = new BankSystem();

        bankSystem.addUser("Myke", "001");
        bankSystem.addUser("Tiffany", "002");

        bankSystem.createAccount("001", 1001, "1234", false, 0);
        bankSystem.createAccount("001", 1002, "5678", true, 500.0);
        bankSystem.createAccount("002", 2001, "1111", true, 1000.0);

        User myke = bankSystem.getUser("001");
        User tiffany = bankSystem.getUser("002");

        myke.listAccounts();
        tiffany.listAccounts();

        Account account1001 = myke.getAccount(1001);
        Account account1002 = myke.getAccount(1002);
        Account account2001 = tiffany.getAccount(2001);

        account1001.deposit(500);
        account1001.withdraw(200);
        account1001.changePin("1234", "4321");

        account1002.deposit(1000);
        account1002.withdraw(600);
        account1002.changePin("5678", "8765");

        account2001.deposit(1500);
        account2001.withdraw(1200);

        myke.listAccounts();
        tiffany.listAccounts();

        CheckingAccount copyAccount = new CheckingAccount((CheckingAccount) account1001);
        System.out.println("Copy of Account 1001: " + copyAccount);
    }
}