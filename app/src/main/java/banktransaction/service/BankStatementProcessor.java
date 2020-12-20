package banktransaction.service;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import banktransaction.model.BankTransaction;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;
    
    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }
    
    public double calculateTotalAmount() {
        return bankTransactions.stream()
                               .mapToDouble(BankTransaction::getAmount)
                               .sum();
    }
    
    public double calculateTotalInMonth(final Month month) {
        return bankTransactions.stream()
                               .filter(transaction -> transaction.getDate().getMonth().equals(month))
                               .mapToDouble(BankTransaction::getAmount)
                               .sum();
    }
    
    public double calculateTotalForCategory(final String category) {
        return bankTransactions.stream()
                               .filter(transaction -> transaction.getDescription().equals(category))
                               .mapToDouble(BankTransaction::getAmount)
                               .sum();
    }
    
    public double calculateMaxAmount() {
        return bankTransactions.stream()
                               .mapToDouble(BankTransaction::getAmount)
                               .max().getAsDouble();
    }
    
    public double calculateMinAmount() {
        return bankTransactions.stream()
                               .mapToDouble(BankTransaction::getAmount)
                               .min().getAsDouble();
    }
    
    public double calculateAverageAmount() {
        return bankTransactions.stream()
                               .mapToDouble(BankTransaction::getAmount)
                               .average().getAsDouble();
    }
    
    public double calculateMaximumInMonth(final Month month) {
        return bankTransactions.stream()
                               .filter(transaction -> transaction.getDate().getMonth().equals(month))
                               .mapToDouble(BankTransaction::getAmount)
                               .max().getAsDouble();
    }
    
    public List<BankTransaction> findTransactionsInMonthGreaterOrEqual(final Month month, final double amount) {
        return findTransactions(transaction -> transaction.getDate().getMonth() == month
                                                && transaction.getAmount() >= amount);
    }
    
    private List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        return bankTransactions.stream().filter(transaction -> bankTransactionFilter.test(transaction))
                                        .collect(Collectors.toList());
    }
}
