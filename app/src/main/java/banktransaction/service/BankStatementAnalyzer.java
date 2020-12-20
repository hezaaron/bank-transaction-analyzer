package banktransaction.service;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import banktransaction.model.BankTransaction;
import banktransaction.model.BankTransactionList;
import banktransaction.model.SummaryStatistics;

public class BankStatementAnalyzer {
    
    public void analyze(final BankTransactionList bankTransactionList) throws IOException {
        final List<BankTransaction> bankTransactions = bankTransactionList.getBankTransactions();
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        final SummaryStatistics summaryStatistics = collectSummary(bankStatementProcessor);
        final DecimalFormat decimalFormat = new DecimalFormat("#.#");
                
        System.out.println("The total for all transactions is " + summaryStatistics.getSum());
        System.out.println("The maximum transaction is " + summaryStatistics.getMax());
        System.out.println("The minimum transaction is " + summaryStatistics.getMin());
        System.out.println("The average transaction is " + decimalFormat.format(summaryStatistics.getAverage()));
        
    }
    
    public SummaryStatistics collectSummary(final BankStatementProcessor bankStatementProcessor) {
        return new SummaryStatistics(bankStatementProcessor.calculateTotalAmount(),
                                     bankStatementProcessor.calculateMaxAmount(),
                                     bankStatementProcessor.calculateMinAmount(),
                                     bankStatementProcessor.calculateAverageAmount());
    }
}
