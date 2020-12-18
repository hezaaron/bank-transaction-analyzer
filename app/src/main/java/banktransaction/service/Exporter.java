package banktransaction.service;

import banktransaction.model.SummaryStatistics;

public class Exporter {
    private final Formatter formatter;
    
    public Exporter(final Formatter formatter) {
        this.formatter = formatter;
    }
    
    public void export(final SummaryStatistics summaryStatistics) {
        formatter.format(summaryStatistics);
    }
}
