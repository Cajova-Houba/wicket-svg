package org.apache.wicket.svg.model;

import org.apache.wicket.model.AbstractReadOnlyModel;

public class PolygonModel extends AbstractReadOnlyModel<PolygonModelItem> {

    private final PolygonModelItem object;

    public PolygonModel(String points, String style) {
        object = new PolygonModelItem(points, style);
    }

    public PolygonModel(String points, String style, String id) {
        this(points, style);
        object.setId(id);
    }

    @Override
    public PolygonModelItem getObject() {
        return object;
    }
}
