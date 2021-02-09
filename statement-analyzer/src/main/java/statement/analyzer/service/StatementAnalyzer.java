package statement.analyzer.service;

import java.util.List;

import statement.analyzer.model.Statement;
import statement.analyzer.model.SummaryStatistics;
import statement.analyzer.model.Transaction;

public class StatementAnalyzer {
    private final Statement statement;
    private final String filePath;
    
    public StatementAnalyzer(final Statement statement, final String filePath) {
        this.statement = statement;
        this.filePath = filePath;
    }
    
    public String exportSummaryStatistics(final Formatter formatter) {
        final Exporter exporter = new Exporter(formatter);
        return exporter.export(analyzeTransactions());
    }
    
    private SummaryStatistics analyzeTransactions() {
        final List<Transaction> transactions = statement.getTrasactions(filePath);
        final StatementProcessor statementProcessor = new StatementProcessor(transactions);
        final SummaryStatistics summaryStatistics = statementProcessor.summarizeTransactions();
        return summaryStatistics;
    }
}
