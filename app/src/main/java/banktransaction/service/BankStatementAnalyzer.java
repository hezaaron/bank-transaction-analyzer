package banktransaction.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import banktransaction.model.BankTransaction;
import banktransaction.model.SummaryStatistics;
import banktransaction.util.BankStatementParser;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "app/src/main/resources/";
    
    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        final SummaryStatistics summaryStatistics = collectSummary(bankStatementProcessor);
        
        System.out.println("The total for all transactions is " + summaryStatistics.getSum());
        System.out.println("The maximum transaction is " + summaryStatistics.getMax());
        System.out.println("The minimum transaction is " + summaryStatistics.getMin());
        System.out.println("The average transaction is " + summaryStatistics.getAverage());
    }
    
    private SummaryStatistics collectSummary(final BankStatementProcessor bankStatementProcessor) {
        return new SummaryStatistics(bankStatementProcessor.calculateTotalAmount(),
                                     bankStatementProcessor.calculateMaxAmount(),
                                     bankStatementProcessor.calculateMinAmount(),
                                     bankStatementProcessor.calculateAverageAmount());
    }
}
