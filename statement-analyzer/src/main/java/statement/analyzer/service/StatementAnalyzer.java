package statement.analyzer.service;

import java.util.List;

import statement.analyzer.model.SummaryStatistics;
import statement.analyzer.model.Transaction;

public class StatementAnalyzer {
    private final Statement statement;
    
    public StatementAnalyzer(final Statement statement) {
        this.statement = statement;
    }
    
    public String exportSummaryStatistics(final Formatter formatter) {
        final Exporter exporter = new Exporter(formatter);
        return exporter.export(analyzeTransactions());
    }
    
    public SummaryStatistics analyzeTransactions() {
        final List<Transaction> transactions = statement.getTrasactions();
        final StatementProcessor statementProcessor = new StatementProcessor(transactions);
        return statementProcessor.summarizeTransactions();
    }
}
