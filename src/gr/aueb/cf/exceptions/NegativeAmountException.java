package gr.aueb.cf.exceptions;

/**
 * Custom Exception for negative amounts
 */
public class NegativeAmountException extends Exception {

    private static final long serialVersionUID = 1L;

    public NegativeAmountException(double amount) {

        super("Amount " + amount + " is negative");
    }
}