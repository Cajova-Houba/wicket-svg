package org.apache.wicket.svg.markup.basic;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupException;
import org.apache.wicket.model.IModel;

/**
 * An abstract class for replacable components. Replacable means that the component can
 * replace &lt;svgComponent&gt; tag with its own tag.
 * @author Zdenda
 *
 */
public abstract class AbstractReplacableSvgComponent<T> extends
		AbstractSvgComponent<T> {
	private static final long serialVersionUID = 1L;
	
	/**
	 * If the tag from the markup has this value, it can be replaced.
	 */
	private static final String REPLACABLE_TAG = "svgComponent";
	
	public AbstractReplacableSvgComponent(String wicketId) {
		super(wicketId);
	}

	public AbstractReplacableSvgComponent(String wicketId, IModel<T> model) {
		super(wicketId, model);
	}

	/**
	 * Checks the tag and if it doesn't match, checks if it's REPLACABLE_TAG. If is, replaces it, if it isn't
	 * throws an exception.
	 */
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
}
