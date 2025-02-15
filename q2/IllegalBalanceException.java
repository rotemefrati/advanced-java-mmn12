package main.java.com.maman12.q2;

// Setting this exception as a subclass of Exception, as requested
public class IllegalBalanceException extends Exception {
    public IllegalBalanceException(String message) {
        super(message);
    }
}
