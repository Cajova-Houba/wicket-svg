package org.apache.wicket.svg.model;

import java.io.Serializable;

public interface SvgTransform extends Serializable{

    /**
     * Returns a string which will be used as component's transform attribute.
     * @return
     */
    String getTransform();
}
