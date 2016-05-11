package org.apache.wicket.svg.markup.basic;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupException;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.svg.model.SvgCoordinate;

public abstract class AbstractCoordinateSvgComponent<T extends SvgCoordinate> extends AbstractSvgComponent<T> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * If the tag from the markup has this value, it can be replaced.
	 */
	private static final String REPLACABLE_TAG = "svgComponent";

	public AbstractCoordinateSvgComponent(final String wicketId) {
		super(wicketId);
		initComponent();
	}

	public AbstractCoordinateSvgComponent(final String wicketId, final IModel<T> model) {
		super(wicketId, model);
		initComponent();
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		try {
			super.onComponentTag(tag);
		} catch (MarkupException e) {
			if(tag.getName().equals(REPLACABLE_TAG)) {
				//set the tag
				tag.setName(getTag());
			} else {
				throw(e);
			}
		}
	}

	protected void initComponent() {
		add(new AttributeModifier(getXAttributeName(), new AbstractReadOnlyModel<String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return Double.toString(getModelObject().getX()) + (getModelObject().isPercent() ? "%" : "");
			}
		}));
		add(new AttributeModifier(getYAttributeName(), new AbstractReadOnlyModel<String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return Double.toString(getModelObject().getY()) + (getModelObject().isPercent() ? "%" : "");
			}
		}));
	}

	protected abstract String getXAttributeName();

	protected abstract String getYAttributeName();

}
