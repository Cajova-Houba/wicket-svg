package org.apache.wicket.svg.markup.basic;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.svg.model.SvgDimensions;

/**
 * A container for svg elements. Use this for the &lt;svg&gt; tag.
 * 
 * The container itself is just modified repeating view so the markup like this is expected:
 * <pre>
 * {@code
 * <svg>
 * 	<svgComponent wicket:id="someId"/>		
 * </svg>
 *  }
 *  </pre>
 *  
 *  {@code svgComponent} tag will be replaced with any svg shape extending the AbstractCoordinateSvgComponent 
 *  you put in this repeating view.
 * @author Zdenda
 *
 */
public class SvgContainer<T extends SvgDimensions> extends RepeatingView {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Tag this component will be asigned to.
	 */
	protected static final String TAG = "svg";
	
	protected static final String WIDTH_ATTR_NAME = "width";
	
	protected static final String HEIGHT_ATTR_NAME = "height";
	
	private IModel<T> model;
	
	public SvgContainer(String id, IModel<T> model) {
		super(id, model);
		this.model = model;
		initComponent();
	}

	public SvgContainer(String id) {
		super(id);
		initComponent();
	}
	
	public IModel<T> getModel() {
		return model;
	}

	public void setModel(IModel<T> model) {
		this.model = model;
	}
	
	public T getModelObject() {
		return model.getObject();
	}

	@Override
	protected void onComponentTag(ComponentTag tag) {
		
		//this container can only be used on svg tag
		checkComponentTag(tag, getTag());
		
		super.onComponentTag(tag);
	}
	
	protected void initComponent() {
		
		//no attributes to add
		if(getModelObject() == null) {
			return;
		}

		//width
		add(new AttributeModifier(getWidthAttributeName(), new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {
				
				return Double.toString(getModelObject().getWidth())+ (getModelObject().isPercent() ? "%" : "");
			}
		}));
		
		//height
		add(new AttributeModifier(getHeightAttributeName(), new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {
				return Double.toString(getModelObject().getHeight()) + (getModelObject().isPercent() ? "%" : "");
			}
			
		}));
	}

	protected String getTag() {
		return TAG;
	}

    protected String getWidthAttributeName() {
    	return WIDTH_ATTR_NAME;
    }
    
    protected String getHeightAttributeName() {
    	return HEIGHT_ATTR_NAME;
    }
	
}
