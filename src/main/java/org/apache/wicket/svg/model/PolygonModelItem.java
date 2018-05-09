package org.apache.wicket.svg.model;

public class PolygonModelItem implements SvgAdditional, SvgPoints {

    private String points;
    private String style;
    private String id;

    public PolygonModelItem(String points, String style) {
        this.points = points;
        this.style = style;
        this.id = "";
    }

    @Override
    public String getStyle() {
        return style;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getPoints() {
        return points;
    }
}
