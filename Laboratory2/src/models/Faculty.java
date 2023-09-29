package models;

public class Faculty {

    private String name;
    private String abbrev;
    private String field;

    public Faculty(String name, String abbrev, String field) {
        this.name = name;
        this.abbrev = abbrev;
        this.field = field;
    }

    @Override
    public String toString() {
        return name + " - " + abbrev + " - " + field;
    }
}
