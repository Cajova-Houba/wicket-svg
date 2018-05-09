package org.apache.wicket.svg.markup.basic;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.svg.model.SvgAdditional;
import org.apache.wicket.svg.model.SvgPoints;

public class Polygon<T extends SvgPoints & SvgAdditional>
        extends AbstractReplacableSvgComponent<T> {

    private final String TAG = "polygon";

    public Polygon(String wicketId, IModel<T> model) {
        super(wicketId, model);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();

        add(new AttributeModifier("points", new AbstractReadOnlyModel<String>() {

            private static final long serialVersionUID = 1L;

            @Override
            public String getObject() {
                return getModelObject().getPoints();
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
