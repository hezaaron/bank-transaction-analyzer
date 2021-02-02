package statement.analyzer.service;

import com.google.gson.Gson;

import statement.analyzer.model.SummaryStatistics;

public class JsonFormat implements Formatter {

    @Override
    public String format(SummaryStatistics summaryStatistics) {
        final Gson gson = new Gson();
        return gson.toJson(summaryStatistics);
    }

}
