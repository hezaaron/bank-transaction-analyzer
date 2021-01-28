package statement.analyzer.service;

import java.util.List;

import statement.analyzer.model.Transaction;

public interface StatementParser {

    List<Transaction> parseLinesFrom(List<String> lines);
    Transaction parseFrom(String line);
}
