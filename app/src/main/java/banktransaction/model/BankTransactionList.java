package banktransaction.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import banktransaction.util.BankStatementParser;

public class BankTransactionList {
    private static final String RESOURCES = "app/src/main/resources/";
    private final String fileName;
    final BankStatementParser bankStatementParser;
    
    public BankTransactionList(final String fileName, final BankStatementParser bankStatementParser) {
        this.fileName = fileName;
        this.bankStatementParser = bankStatementParser;
    }
    
    public List<BankTransaction> getBankTransactions() throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        
        return bankStatementParser.parseLinesFrom(lines);
    }
}
