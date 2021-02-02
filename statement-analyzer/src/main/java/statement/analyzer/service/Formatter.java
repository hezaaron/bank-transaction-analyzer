package statement.analyzer.service;

import statement.analyzer.model.SummaryStatistics;

public interface Formatter {
    String format(SummaryStatistics summaryStatistics);
}
