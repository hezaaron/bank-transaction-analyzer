package statement.analyzer.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import document.management.DocumentManagement;
import document.management.model.Attribute;
import document.management.model.Document;
import statement.analyzer.model.Transaction;

public class Statement {
    private static final String BANK_STATEMENT = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"BankStatement.csv";
    private final DocumentManagement documentManager;
    
    public Statement() {
        documentManager = new DocumentManagement();
    }
    
    public List<Transaction> getTrasactions() {
        importFile();
        final Document document = documentManager.contents().get(0);
        final String transactions = document.getAttribute(Attribute.TRANSACTIONS.toString());
        final List<String> lines = Arrays.asList(transactions.split("\n"));
        final StatementParser csvFileParser = new CSVFileParser();

        return csvFileParser.parseLinesFrom(lines);
    }
    
    private void importFile() {
        try {
            documentManager.importFile(BANK_STATEMENT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
