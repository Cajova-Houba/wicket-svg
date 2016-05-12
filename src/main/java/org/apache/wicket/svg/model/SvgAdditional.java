package org.apache.wicket.svg.model;

import java.io.Serializable;

/**
 * Interface used to specify additional components attributes, such as style or id.
 * 
 * @author Zdenda
 *
 */
public interface SvgAdditional extends Serializable {

	/**
	 * Returns a string for component's 'style' attribute.
	 * @return
	 */
	public String getStyle();
	
	/**
	 * Returns a string which will be used as components uid attribute.
	 * @return
	 */
	public String getId();
}
