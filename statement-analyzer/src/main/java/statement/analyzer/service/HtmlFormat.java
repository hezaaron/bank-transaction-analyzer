package statement.analyzer.service;

import statement.analyzer.model.SummaryStatistics;

public class HtmlFormat implements Formatter {

    @Override
    public String format(SummaryStatistics summaryStatistics) {
        String htmlDocument = "<!doctype html>";
        htmlDocument += "<html lang='en'>";
        htmlDocument += "<head><title>Bank Transaction Report</title></head>";
        htmlDocument += "<body>";
        htmlDocument += "<ul>";
        htmlDocument += "<li><strong>The sum is</strong>: " + summaryStatistics.getSum() + "</li>";
        htmlDocument += "<li><strong>The max is</strong>: " + summaryStatistics.getMax() + "</li>";
        htmlDocument += "<li><strong>The min is</strong>: " + summaryStatistics.getMin() + "</li>";
        htmlDocument += "<li><strong>The average is</strong>: " + summaryStatistics.getAverage() + "</li>";
        htmlDocument += "</ul>";
        htmlDocument += "</body>";
        htmlDocument += "</html>";
        return htmlDocument;
    }

}
