package org.apache.wicket.svg.model;

public class TextModelItem implements SvgCoordinate, SvgTransform, SvgAdditional {
	private static final long serialVersionUID = 1L;
	
	private double x;
	private double y;
	private boolean percent;
	private String text;
	private String style;
	private String transform;
	private String id;

	public TextModelItem(double x, double y, boolean percent, String text, String style, String transform, String id) {
		this.x = x;
		this.y = y;
		this.percent = percent;
		this.text = text;
		this.style = style;
		this.transform = transform;
		this.id = id;
	}

	public TextModelItem(double x, double y, boolean percent, String text, String style, String transform) {
		this(x,y,percent,text,style,transform,"");
	}

	public TextModelItem(final double x, final double y, final boolean percent, String text, String style) {
		this(x,y,percent,text,style, "");
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

	@Override
	public String getTransform() {
		return transform;
	}

	public void setTransform(String transform) {
		this.transform = transform;
	}

	@Override
	public String getId() {
		return id;
	}
}
