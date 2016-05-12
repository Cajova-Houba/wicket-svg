package org.apache.wicket.svg.model;

import org.apache.wicket.model.AbstractReadOnlyModel;

public class RectModel extends AbstractReadOnlyModel<RectModelItem> {
	private static final long serialVersionUID = 1L;
	
	
	private final RectModelItem rectModelItem;

    public RectModel(final double x, final double y, final double width, final double height, final boolean percent) {
        rectModelItem = new RectModelItem(x, y, width, height, percent);
    }
    
    public RectModel(final double x, final double y, final double width, final double height, final boolean percent, final String style) {
    	this(x,y,width,height,percent);
    	rectModelItem.setStyle(style);
    }
    
    public RectModel(final double x, final double y, final double width, final double height, final boolean percent, final String style, String id) {
    	this(x,y,width,height,percent);
    	rectModelItem.setStyle(style);
    	rectModelItem.setId(id);
    }

    @Override
    public RectModelItem getObject() {
        return rectModelItem;
    }
}
