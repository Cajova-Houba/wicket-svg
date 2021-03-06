package org.apache.wicket.svg.markup.path;

import org.apache.wicket.model.IModel;

public class RelativeVerticalLineto extends AbstractLinetoPathSegment {

    private static final long serialVersionUID = 1L;

    public RelativeVerticalLineto(final IModel<Double> linetoModel) {
        super(linetoModel);
    }

    @Override
    protected String getCommand() {
        return "v";
    }
}
