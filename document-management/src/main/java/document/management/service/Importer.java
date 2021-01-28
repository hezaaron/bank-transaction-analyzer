package document.management.service;

import java.io.File;
import java.io.IOException;

import document.management.model.Document;

public interface Importer {
    Document importFile(File file) throws IOException;
}
