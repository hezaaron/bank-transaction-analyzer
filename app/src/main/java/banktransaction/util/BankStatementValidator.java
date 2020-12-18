package banktransaction.util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class BankStatementValidator {
    private final String date;
    private final String amount;
    private final String description;
    
    public BankStatementValidator(final String date, final String amount, final String description) {
        this.date = date;
        this.amount = amount;
        this.description = description;
    }
    
    public Notification validate() {
        final Notification notification = new Notification();
        
        final LocalDate parseDate;
        try {
            parseDate = LocalDate.parse(this.date);
            if (parseDate.isAfter(LocalDate.now())) {
                notification.addError("date cannot be in the future");
            }
        } catch (DateTimeParseException e) {
            notification.addError("Invalid format for date");
        }
        
        @SuppressWarnings("unused")
        final double amount;
        try {
            amount = Double.parseDouble(this.amount);
        } catch (NumberFormatException e) {
            notification.addError("Invalid format for amount");
        }
        
        if (this.description.length() > 100) {
            notification.addError("The description is too long");
        }
        
        return notification;
    }
}
