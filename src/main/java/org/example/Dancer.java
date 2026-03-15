package org.example;
public class Dancer {
    private String name;
    private String style;
    public Dancer() {}
    public Dancer(String name, String style) {
        this.name = name;
        this.style = style;
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStyle() { return style; }
    public void setStyle(String style) { this.style = style; }
}