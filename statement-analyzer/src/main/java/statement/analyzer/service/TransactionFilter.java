package statement.analyzer.service;

import statement.analyzer.model.Transaction;

@FunctionalInterface
public interface TransactionFilter {
    boolean test(Transaction transaction);
}
