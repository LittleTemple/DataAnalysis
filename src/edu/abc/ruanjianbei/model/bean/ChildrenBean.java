package edu.abc.ruanjianbei.model.bean;

public class ChildrenBean {
	
	private String id;
	private String parentId;
	private String value;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public ChildrenBean(String id, String parentId, String value) {
		super();
		this.id = id;
		this.parentId = parentId;
		this.value = value;
	}
	public ChildrenBean() {
		super();
	}
	@Override
	public String toString() {
		return "Children [id=" + id + ", parentId=" + parentId + ", value=" + value + "]";
	}
	
}
