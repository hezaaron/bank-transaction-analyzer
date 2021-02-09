package statement.analyzer.model;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import document.management.DocumentManagement;
import document.management.model.Attribute;
import document.management.model.Document;
import statement.analyzer.service.StatementParser;

public class Statement {
    //private static final String RESOURCES = "src"+File.separator+"test"+File.separator+"resources"+File.separator+"BankStatement.csv";
    private final DocumentManagement documentManagementSystem;
    private final StatementParser statementParser;
    
    public Statement(final StatementParser statementParser, final DocumentManagement documentMangementSystem) {
        this.statementParser = statementParser;
        this.documentManagementSystem = documentMangementSystem;
    }
    
    
    public List<Transaction> getTrasactions(final String filePath) {
        importFile(filePath);
        final Document document = documentManagementSystem.contents().get(0);
        final String transactions = document.getAttribute(Attribute.TRANSACTIONS);
        final List<String> lines = Arrays.asList(transactions.split("\n"));

        return statementParser.parseLinesFrom(lines);
    }
    
    private void importFile(final String filePath) {
        try {
            documentManagementSystem.importFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
