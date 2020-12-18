package banktransaction.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import banktransaction.model.BankTransaction;

public class BankStatementCSVParser implements BankStatementParser{
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public List<BankTransaction> parseLinesFrom(final List<String> lines) {
        return lines.stream().map(line -> parseFrom(line))
                             .collect(Collectors.toList());
    }
    
    public BankTransaction parseFrom(final String line) {
        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];
        
        return new BankTransaction(date, amount, description);
    }
}