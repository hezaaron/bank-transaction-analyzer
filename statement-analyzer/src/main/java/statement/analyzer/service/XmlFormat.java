/**
 * 
 */
package statement.analyzer.service;

import statement.analyzer.model.SummaryStatistics;

public class XmlFormat implements Formatter {

    @Override
    public String format(SummaryStatistics summaryStatistics) {
        String xmlDocument = "<?xml version='1.0' encoding='UTF-8'?>";
        xmlDocument += "<report>";
        xmlDocument +=     "<title>";
        xmlDocument +=         "Bank Transaction Report";
        xmlDocument +=     "</title>";
        xmlDocument +=     "<statistics>";
        xmlDocument +=         "<sum>" + summaryStatistics.getSum() + "</sum>";
        xmlDocument +=         "<max>" + summaryStatistics.getMax() + "</max>";
        xmlDocument +=         "<min>" + summaryStatistics.getMin() + "</min>";
        xmlDocument +=         "<average>" + summaryStatistics.getAverage() + "</average>";
        xmlDocument +=     "</statistics>";
        xmlDocument += "</report>";
        return xmlDocument;
    }
}
