package document.management.model;

public enum Attribute {
    PATH("path"), TRANSACTIONS("transactions"), HEIGTH("height"),
    WIDTH("width"), TYPE("type");
    
    private final String value;
    
    private Attribute(final String value) {
        this.value = value;
    }
    
    public String toString() {
        return value;
    }
}
