package org.apache.wicket.svg.markup.basic;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.svg.model.TextModelItem;

public class Text extends AbstractCoordinateSvgComponent<TextModelItem> {
	private static final long serialVersionUID = 1L;

	public Text(final String wicketId, final IModel<TextModelItem> model) {
		super(wicketId, model);
	}

	@Override
	protected void initComponent() {
		super.initComponent();
		
		if(getModelObject().getStyle().length() > 0) {
			add(new AttributeModifier("style", new AbstractReadOnlyModel<String>() {

				@Override
				public String getObject() {
					return getModelObject().getStyle();
				}
				
			}));
		}

		if(getModelObject().getTransform().length() > 0) {
			add(new AttributeModifier("transform", new AbstractReadOnlyModel<String>() {
				@Override
				public String getObject() {
					return getModelObject().getTransform();
				}
			}));
		}
	}
	
	/**
	 * Renders the text.
	 * @param markupStream
	 * @param openTag
	 */
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		replaceComponentTagBody(markupStream, openTag, getModelObject().getText());
	}
	
	@Override
	protected String getXAttributeName() {
		return "x";
	}

	@Override
	protected String getYAttributeName() {
		return "y";
	}

	@Override
	protected String getTag() {
		return "text";
	}
}
