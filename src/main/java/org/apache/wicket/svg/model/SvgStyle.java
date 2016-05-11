package org.apache.wicket.svg.model;

import java.io.Serializable;

/**
 * Interface used to specify a component's style.
 * 
 * @author Zdenda
 *
 */
public interface SvgStyle extends Serializable {

	/**
	 * Returns a string for component's 'style' attribute.
	 * @return
	 */
	public String getStyle();
}
