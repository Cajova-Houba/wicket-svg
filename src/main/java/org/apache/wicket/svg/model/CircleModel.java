package org.apache.wicket.svg.model;

import org.apache.wicket.model.AbstractReadOnlyModel;

public class CircleModel extends AbstractReadOnlyModel<CircleModelItem> {

    private static final long serialVersionUID = 1L;

    private final CircleModelItem modelItem;

    public CircleModel(final double x, final double y, final double radius, final boolean percent) {
        modelItem = new CircleModelItem(x, y, radius, percent);
    }
    public CircleModel(final double x, final double y, final double radius, final boolean percent, final String style) {
        modelItem = new CircleModelItem(x, y, radius, percent);
        modelItem.setStyle(style);
    }
    public CircleModel(final double x, final double y, final double radius, final boolean percent, final String style, final String uid) {
        modelItem = new CircleModelItem(x, y, radius, percent);
        modelItem.setStyle(style);
        modelItem.setId(uid);
    }

    @Override
    public CircleModelItem getObject() {
        return modelItem;
    }

}
