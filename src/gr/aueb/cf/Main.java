package gr.aueb.cf;

import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;
import gr.aueb.cf.model.Account;
import gr.aueb.cf.model.OverDraftJointAccount;
import gr.aueb.cf.model.OverdraftAccount;
import gr.aueb.cf.model.User;

public class Main {
    public static void main(String[] args) {

        User sav = new User("Sav", "Ampa", "12345");
        Account account = new Account(sav, "GR12345", 1000);

        User anna =  new User("Anna", "Tio", "3214");
        Account overJointAccount = new OverDraftJointAccount(anna, "GR2365", 200.50, anna);

        try {

            System.out.println("Account: \n" + account);
            Account overSav = new OverdraftAccount(sav, "GR678", 500);
            System.out.println("Overdraft: \n" + overSav);

            overJointAccount.deposit(100);
            overJointAccount.withdraw(50, "3214");

            System.out.println("Overdraft joint account: \n" + overJointAccount);

        } catch (NegativeAmountException | InsufficientBalanceException | SsnNotValidException e) {
            System.out.println(e.getMessage());
        }
    }
}
