package org.apache.wicket.svg.model;

public class RectModelItem implements SvgCoordinate, SvgHeight, SvgWidth, SvgXYRadius, SvgAdditional {
	private static final long serialVersionUID = 1L;
	
	
	private double x;
	private double y;
	private double rx;
	private double ry;
	private double width;
	private double height;
	private boolean percent;
	private String style;
	private String id;

	public RectModelItem() {
	}

	public RectModelItem(final double x, final double y, final boolean percent) {
		this.x = x;
		this.y = y;
		this.percent = percent;
		style="";
		id="";
	}

	public RectModelItem(final double x, final double y, final double width, final double height,
			final boolean percent) {
		this(x,y,percent);
		this.width = width;
		this.height = height;
	}

	public RectModelItem(final double x, final double y, final double width, final double height,
			final double rx, final double ry) {
		this(x,y,width, height, false);
		this.rx = rx;
		this.ry = ry;
	}

	@Override
	public double getX() {
		return x;
	}

	public void setX(final double x) {
		this.x = x;
	}

	@Override
	public double getY() {
		return y;
	}

	public void setY(final double y) {
		this.y = y;
	}

	@Override
	public double getWidth() {
		return width;
	}

	public void setWidth(final double width) {
		this.width = width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	public void setHeight(final double height) {
		this.height = height;
	}

	@Override
	public double getRX() {
		return rx;
	}

	public void setRX(final double rx) {
		this.rx = rx;
	}

	@Override
	public double getRY() {
		return ry;
	}

	public void setRY(final double ry) {
		this.ry = ry;
	}

	@Override
	public boolean isPercent() {
		return percent;
	}

	public void setPercent(final boolean percent) {
		this.percent = percent;
	}

	@Override
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
