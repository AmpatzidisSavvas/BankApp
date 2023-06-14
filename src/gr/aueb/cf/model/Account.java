package gr.aueb.cf.model;

import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;

/**
 * Account Class
 */
public class Account extends IdentifiableEntity {

    private User holder = new User();
    private String iban;
    private double balance;

    public Account() {}

    public Account(User holder, String iban, double balance) {
        this.holder = holder;
        this.iban = iban;
        this.balance = balance;
    }

    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "holder=" + holder +
                ", iban='" + iban + '\'' +
                ", balance=" + balance +
                '}';
    }

    //Public API

    /**
     * Deposits a certain amount of money
     * @param amount
     *          the amount of money to be deposited
     * @throws NegativeAmountException
     *          if the amount is negative
     */
    public void deposit(double amount) throws NegativeAmountException {

        try {

            if (amount < 0 ) {
                throw new NegativeAmountException(amount);
            }

            balance += amount;

        } catch (NegativeAmountException e) {
            System.err.println("Error: Negative Amount");
            throw e;
        }
    }


    /**
     *
     * @param amount:  the amount of money to be withdraws
     * @param ssn : the given ssn
     * @throws InsufficientBalanceException: if the amount is greater than balance
     * @throws SsnNotValidException: if the ssn is not valid
     * @throws NegativeAmountException : if the amount is negative
     */
    public void withdraw(double amount, String ssn)
            throws InsufficientBalanceException, SsnNotValidException, NegativeAmountException {

        try {

            if (amount < 0) {
                throw new NegativeAmountException(amount);
            }

            if (amount > balance) {
                throw new InsufficientBalanceException(getBalance(), amount);
            }

            if (!isSsnValid(ssn)) {
                throw new SsnNotValidException(ssn);
            }

            balance -= amount;

        } catch (InsufficientBalanceException | SsnNotValidException | NegativeAmountException e ) {
            System.err.println("Error: withdrawal");
            throw e;
        }
    }

    protected boolean isSsnValid(String ssn) {

        if (ssn == null || holder.getSsn() == null) {
            return false;
        }

        return holder.getSsn().equals(ssn);
    }
}