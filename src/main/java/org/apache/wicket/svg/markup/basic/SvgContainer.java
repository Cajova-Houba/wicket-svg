package org.apache.wicket.svg.markup.basic;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.svg.model.SvgDimensions;

/**
 * A container for svg elements. Use this for the &lt;svg&gt; tag.
 * 
 * The container itself contains a repeating view for SVG components so the markup like this is expected:
 * <pre>
 * {@code
 * <svg>
 * 	<svgComponent wicket:id="components"/>		
 * </svg>
 *  }
 *  </pre>
 *  
 *  {@code svgComponent} tag will be replaced with any svg shape extending the AbstractCoordinateSvgComponent 
 *  you add via add() method.
 * @author Zdenda
 *
 */
public class SvgContainer<T extends SvgDimensions> extends AbstractSvgComponent<T> {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Tag this component will be asigned to.
	 */
	protected static final String TAG = "svg";
	
	/**
	 * A tag for components repeating view.
	 */
	protected static final String COMPONENTS = "components";
	
	protected static final String WIDTH_ATTR_NAME = "width";
	
	protected static final String HEIGHT_ATTR_NAME = "height";
	
	private IModel<T> model;
	
	/**
	 * Repeating view to display SVG components
	 */
	private RepeatingView components;
	
	/**
	 * You can use this constructor to specify dimensions of the svg element.
	 * @param id Wicket id.
	 * @param model Model of {@code SvgDimensions} object
	 */
	public SvgContainer(String id, IModel<T> model) {
		super(id, model);
		this.model = model;
		initComponent();
	}

	public SvgContainer(String id) {
		super(id);
		initComponent();
	}
	
	/**
	 * Creates a new dimensions model with defined width and height. Percent is set to false.
	 * @param w
	 * @param h
	 * @return
	 */
	public static IModel<SvgDimensions> createSimpleDimensionsModel(final double w, final double h) {
		return new Model<SvgDimensions>(new SvgDimensions() {
			
			@Override
			public double getWidth() {
				return w;
			}
			
			@Override
			public double getHeight() {
				return h;
			}
			
			@Override
			public boolean isPercent() {
				return false;
			}
		});
	}
	
	public IModel<T> getModel() {
		return model;
	}

	public void setModel(IModel<T> model) {
		this.model = model;
	}
	
	public T getModelObject() {
		return getModel() == null ? null : model.getObject();
	}

	@Override
	protected void onComponentTag(ComponentTag tag) {
		
		//this container can only be used on svg tag
		checkComponentTag(tag, getTag());
		
		super.onComponentTag(tag);
		
	}
	
	protected void initComponent() {
		
		components = new RepeatingView(COMPONENTS);
		super.add(components);
		
		//no attributes to add
		if(getModelObject() == null) {
			return;
		}

		
		//width
		add(new AttributeModifier(getWidthAttributeName(), new AbstractReadOnlyModel<String>() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				
				return Double.toString(getModelObject().getWidth())+ (getModelObject().isPercent() ? "%" : "");
			}
		}));
		
		//height
		add(new AttributeModifier(getHeightAttributeName(), new AbstractReadOnlyModel<String>() {
			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return Double.toString(getModelObject().getHeight()) + (getModelObject().isPercent() ? "%" : "");
			}
			
		}));
	}

	@Override
	public MarkupContainer add(Component... childs) {
		
		//add svg components to the repeater
		for(Component child : childs) {
			if(child instanceof AbstractCoordinateSvgComponent) {
				components.add(child);
			} else {
				add(child);
			}
		}

		return this;
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
    
    public String newChildId() {
    	return components.newChildId();
    }
    
}
