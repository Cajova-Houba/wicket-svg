package org.apache.wicket.svg.markup.basic;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.svg.model.SvgAdditional;
import org.apache.wicket.svg.model.SvgSimplePath;

/**
 * A simple path. 
 * @author Zdenda
 */
public class SimplePath<T extends SvgAdditional & SvgSimplePath> extends AbstractReplacableSvgComponent<T> {
	private static final long serialVersionUID = 1L;
	private final String TAG = "path";
	
	public SimplePath(String wicketId, IModel<T> model) {
		super(wicketId, model);
		initComponent();
	}
	
	protected void initComponent() {
		add(new AttributeModifier("d", new AbstractReadOnlyModel<String>() {
			
			private static final long serialVersionUID = 1L;
			
			@Override
			public String getObject() {
				return getModelObject().getD(); 
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
	protected String getTag() {
		return TAG;
	}
	
}
