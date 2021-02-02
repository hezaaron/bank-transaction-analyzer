package statement.analyzer.service;

import statement.analyzer.model.Transaction;

@FunctionalInterface
public interface TransactionSummarizer {
    double summarize(double accumulator, Transaction transaction);
}
