package exceptions;

public class InappropriateLoanRequest extends Exception{
    public InappropriateLoanRequest(String message) {
        super(message);
    }
}
