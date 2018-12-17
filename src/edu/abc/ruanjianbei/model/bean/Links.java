package edu.abc.ruanjianbei.model.bean;

public class Links {
	private String source;
	private String target;
	private String value;
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Links() {
		super();
	}
	public Links(String source, String target, String value) {
		super();
		this.source = source;
		this.target = target;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Links [source=" + source + ", target=" + target + ", value=" + value + "]";
	}
	
}
