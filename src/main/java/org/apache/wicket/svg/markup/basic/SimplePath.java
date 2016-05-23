package org.apache.wicket.svg.markup.basic;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

/**
 * A simple path. 
 * @author Zdenda
 *
 * @param <T> 'd' attribute of the path specifing path commands.
 */
public class SimplePath<T extends String> extends AbstractReplacableSvgComponent<T> {

	private final String TAG = "path";
	
	public SimplePath(String wicketId, IModel<T> model) {
		super(wicketId, model);
		
		final String d = model.getObject() == null ? "" : model.getObject();
		
		add(new AttributeModifier("d", new AbstractReadOnlyModel<String>() {

			private static final long serialVersionUID = 1L;

			@Override
			public String getObject() {
				return d; 
			}
		}));
	}

	@Override
	protected String getTag() {
		return TAG;
	}
	
}
