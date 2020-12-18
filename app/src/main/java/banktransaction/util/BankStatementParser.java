package banktransaction.util;

import java.util.List;

import banktransaction.model.BankTransaction;

public interface BankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}