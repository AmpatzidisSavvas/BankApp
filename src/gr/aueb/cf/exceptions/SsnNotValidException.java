package gr.aueb.cf.exceptions;

/**
 * Custom Exception for validation for Ssn
 */
public class SsnNotValidException extends Exception{

    private static final long serialVersionUID = 1L;

    public SsnNotValidException(String ssn) {

        super("Ssn " + ssn + " is not valid");
    }
}
