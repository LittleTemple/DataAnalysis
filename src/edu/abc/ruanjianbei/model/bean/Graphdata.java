package edu.abc.ruanjianbei.model.bean;

public class Graphdata {
	private String name;
	private int category;
	private String draggable;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getDraggable() {
		return draggable;
	}
	public void setDraggable(String draggable) {
		this.draggable = draggable;
	}
	public Graphdata(String name, int category, String draggable) {
		super();
		this.name = name;
		this.category = category;
		this.draggable = draggable;
	}
	public Graphdata() {
		super();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category;
		result = prime * result + ((draggable == null) ? 0 : draggable.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Graphdata other = (Graphdata) obj;
		if (category != other.category)
			return false;
		if (draggable == null) {
			if (other.draggable != null)
				return false;
		} else if (!draggable.equals(other.draggable))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Graphdata [name=" + name + ", category=" + category + ", draggable=" + draggable + "]";
	}
	
}
