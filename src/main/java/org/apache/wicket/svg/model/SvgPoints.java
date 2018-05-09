package org.apache.wicket.svg.model;

import java.io.Serializable;

/**
 * Interface used to specify that svg element has point attribute.
 */
public interface SvgPoints extends Serializable {

    /**
     * Returns the value of 'points' attribute.
     * @return
     */
    String getPoints();
}
