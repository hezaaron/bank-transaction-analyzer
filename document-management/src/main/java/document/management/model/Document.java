package document.management.model;

import java.util.Map;

public class Document {
    private final Map<String, String> attributes;
    
    public Document(final Map<String, String> attributes) {
        this.attributes = attributes;
    }
    
    public String getAttribute(final String attribute) {
        return attributes.get(attribute);
    }
}
