package document.management.service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import document.management.model.Attribute;
import document.management.model.Document;
import document.management.model.TextFile;

public class StatementImporter implements Importer {

    @Override
    public Document importFile(File file) throws IOException {
        final TextFile textFile = new TextFile(file);
        textFile.addLines(0, String::isEmpty, Attribute.TRANSACTIONS);
        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(Attribute.TYPE, "BANKSTATEMENT");
        return new Document(attributes);
    }

}
