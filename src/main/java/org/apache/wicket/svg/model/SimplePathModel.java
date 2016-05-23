package org.apache.wicket.svg.model;

import org.apache.wicket.model.AbstractReadOnlyModel;

public class SimplePathModel extends AbstractReadOnlyModel<SimplePathModelItem> {
	private static final long serialVersionUID = 1L;
	
	private final SimplePathModelItem modelItem;
	
	public SimplePathModel(SimplePathModelItem modelItem) {
		super();
		this.modelItem = modelItem;
	}

	@Override
	public SimplePathModelItem getObject() {
		return modelItem;
	}

	

	
}
