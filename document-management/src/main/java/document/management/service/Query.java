package document.management.service;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import document.management.model.Document;

public class Query implements Predicate<Document> {
    private final Map<String, String> clauses;
    
    private Query(final Map<String, String> clauses) {
        this.clauses = clauses;
    }
    
    public static Query parse(final String query) {
        return new Query(Arrays.stream(query.split(","))
                               .map(str -> str.split(":"))
                               .collect(Collectors.toMap(x -> x[0], x -> x[1])));
    }

    @Override
    public boolean test(Document document) {
        return clauses.entrySet()
                      .stream()
                      .allMatch(entry -> {
                          final String documentValue = document.getAttribute(entry.getKey());
                          final String queryValue = entry.getValue();
                          return documentValue != null && documentValue.contains(queryValue);
                      });
    }
    
}
