package org.apache.wicket.svg.model;

import org.apache.wicket.model.AbstractReadOnlyModel;

public class EllipseModel extends AbstractReadOnlyModel<EllipseModelItem> {

    private final EllipseModelItem ellipseModelItem;

    public EllipseModel(final double cx, final double cy, final double rx, final double ry, final boolean percent) {
        ellipseModelItem = new EllipseModelItem(cx, cy, rx, ry, percent);
    }
    
    public EllipseModel(final double cx, final double cy, final double rx, final double ry, final boolean percent, String style) {
        ellipseModelItem = new EllipseModelItem(cx, cy, rx, ry, percent);
        ellipseModelItem.setStyle(style);
    }

    @Override
    public EllipseModelItem getObject() {
        return ellipseModelItem;
    }
}
