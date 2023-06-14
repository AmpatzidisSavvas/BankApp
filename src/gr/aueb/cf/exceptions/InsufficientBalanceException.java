package gr.aueb.cf.exceptions;

/**
 * Custom Exception for insufficient balances
 */
public class InsufficientBalanceException extends Exception{

    private static final long serialVersionUID = 1L;

    public InsufficientBalanceException(double balance, double amount) {

        super("Insufficient balance " + balance + " for amount" + amount);
    }
}