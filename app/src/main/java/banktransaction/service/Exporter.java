package banktransaction.service;

import banktransaction.model.SummaryStatistics;

public class Exporter {
    private final Formatter formatter;
    
    public Exporter(final Formatter formatter) {
        this.formatter = formatter;
    }
    
    public String export(final SummaryStatistics summaryStatistics) {
        return formatter.format(summaryStatistics);
    }
}
