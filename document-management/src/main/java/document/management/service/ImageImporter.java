package document.management.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import document.management.model.Attribute;
import document.management.model.Document;

public class ImageImporter implements Importer {

    @Override
    public Document importFile(File file) throws IOException {
        final Map<String, String> attributes = new HashMap<>();
        final BufferedImage image = ImageIO.read(file);
        
        attributes.put(Attribute.PATH, file.getPath());
        attributes.put(Attribute.HEIGTH, String.valueOf(image.getHeight()));
        attributes.put(Attribute.WIDTH, String.valueOf(image.getWidth()));
        attributes.put(Attribute.TYPE, "IMAGE");
        
        return new Document(attributes);
    }

}
