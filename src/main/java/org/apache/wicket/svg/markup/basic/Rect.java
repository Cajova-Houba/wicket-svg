package org.apache.wicket.svg.markup.basic;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.svg.model.SvgCoordinate;
import org.apache.wicket.svg.model.SvgHeight;
import org.apache.wicket.svg.model.SvgAdditional;
import org.apache.wicket.svg.model.SvgWidth;
import org.apache.wicket.svg.model.SvgXYRadius;

public class Rect<T extends SvgCoordinate & SvgWidth & SvgHeight & SvgXYRadius & SvgAdditional>
		extends AbstractCoordinateSvgComponent<T> {

	private static final long serialVersionUID = 1L;

	private AjaxEventBehavior eventBehavior;
	
	public Rect(final String wicketId, final IModel<T> model) {
		super(wicketId, model);
	}

	@Override
	protected void onComponentTag(ComponentTag tag) {
		
		//let parent object handle the tag
		super.onComponentTag(tag);
		
		//add the event behavior if any
//		if(getEventBehavior() != null) {
//			add(getEventBehavior());
//		}
	}
	
	@Override
	protected void initComponent() {
		super.initComponent();
		add(new AttributeModifier("width", new AbstractReadOnlyModel<String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return Double.toString(getModelObject().getWidth()) + (getModelObject().isPercent() ? "%" : "");
			}
		}));
		add(new AttributeModifier("height", new AbstractReadOnlyModel<String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return Double.toString(getModelObject().getHeight()) + (getModelObject().isPercent() ? "%" : "");
			}
		}));
		add(new AttributeModifier("rx", new AbstractReadOnlyModel<String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return Double.toString(getModelObject().getRX()) + (getModelObject().isPercent() ? "%" : "");
			}
		}));
		add(new AttributeModifier("ry", new AbstractReadOnlyModel<String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return Double.toString(getModelObject().getRY()) + (getModelObject().isPercent() ? "%" : "");
			}
		}));
		
		if(getModelObject().getStyle().length() > 0) {
			add(new AttributeModifier("style", new AbstractReadOnlyModel<String>() {

				@Override
				public String getObject() {
					return getModelObject().getStyle();
				}
				
			}));
		}
		
		if(getModelObject().getId().length() > 0) {
			add(new AttributeModifier("uid", new AbstractReadOnlyModel<String>() {

				@Override
				public String getObject() {
					return getModelObject().getId();
				}
				
			}));
		}
	}

	@Override
	protected String getXAttributeName() {
		return "x";
	}

	@Override
	protected String getYAttributeName() {
		return "y";
	}

	public AjaxEventBehavior getEventBehavior() {
		return eventBehavior;
	}

	/**
	 * Use this method to set the event behavior. Only one behavior object is permitted.
	 * @param eventBehavior
	 */
	public void setEventBehavior(AjaxEventBehavior eventBehavior) {
		this.eventBehavior = eventBehavior;
	}

	@Override
	protected String getTag() {
		return "rect";
	}
}
