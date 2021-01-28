package document.management.service;

@SuppressWarnings("serial")
public class UnknownFileTypeException extends RuntimeException {
    
    public UnknownFileTypeException(final String message) {
        super(message);
    }
}
