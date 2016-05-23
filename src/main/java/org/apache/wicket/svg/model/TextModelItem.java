package org.apache.wicket.svg.model;

public class TextModelItem implements SvgCoordinate {
	private static final long serialVersionUID = 1L;
	
	private double x;
	private double y;
	private boolean percent;
	private String text;
	private String style;

	public TextModelItem(final double x, final double y, final boolean percent, String text, String style) {
		this.x = x;
		this.y = y;
		this.text = text;
		this.percent = percent;
		this.style = style;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public boolean isPercent() {
		return percent;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
	
	
}
