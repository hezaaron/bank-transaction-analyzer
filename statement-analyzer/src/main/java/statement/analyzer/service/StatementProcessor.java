package statement.analyzer.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import statement.analyzer.model.SummaryStatistics;
import statement.analyzer.model.Transaction;

public class StatementProcessor {
    private final List<Transaction> transactions;
    
    public StatementProcessor(final List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    public SummaryStatistics summarizeTransactions() {
        final DoubleSummaryStatistics summaryStatistics = transactions.stream()
                                                                      .mapToDouble(Transaction::getAmount)
                                                                      .summaryStatistics();
        return new SummaryStatistics(summaryStatistics.getSum(), summaryStatistics.getMax(),
                                     summaryStatistics.getMin(), summaryStatistics.getAverage());
    }
    
    public double calculateTotalInMonth(final Month month) {
        return summarizeTransactions(
         (accumulator, transaction) -> transaction.getDate().getMonth() == month ? accumulator + transaction.getAmount() : accumulator);
    }
    
    public double summarizeTransactions(final TransactionSummarizer transactionSummarizer) {
        double result = 0;
        for (final Transaction transaction : transactions) {
            result = transactionSummarizer.summarize(result, transaction);
        }
        return result;
    }
    
    public List<Transaction> findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(transaction -> transaction.getAmount() >= amount);
    }
    
    public List<Transaction> findTransactions(final TransactionFilter transactionFilter) {
        final List<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transactionFilter.test(transaction)) result.add(transaction);
        }
        return result;
    }
}
