package org.apache.wicket.svg.model;

/**
 * Tagging interface for dimension specifying objects.
 * @author Zdenda
 *
 */
public interface SvgDimensions extends SvgHeight, SvgWidth {

	public boolean isPercent();
}
