package org.apache.wicket.svg.model;

public class SimplePathModelItem implements SvgAdditional, SvgSimplePath{
	private static final long serialVersionUID = 1L;

	private String d;
	
	private String style;
	
	private String id;

	public SimplePathModelItem(String d, String style, String id) {
		super();
		this.d = d;
		this.style = style;
		this.id = id;
	}


	public void setD(String d) {
		this.d = d;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getD() {
		return d;
	}

	@Override
	public String getStyle() {
		return style;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "SimplePathModelItem [d=" + d + ", style=" + style + ", id="
				+ id + "]";
	}
	
	
	
}
