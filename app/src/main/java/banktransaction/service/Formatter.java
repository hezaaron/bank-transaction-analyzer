package banktransaction.service;

import banktransaction.model.SummaryStatistics;

public interface Formatter {
    String format(SummaryStatistics summaryStatistics);
}
