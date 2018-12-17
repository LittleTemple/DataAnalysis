package edu.abc.ruanjianbei.model.bean;

import java.util.ArrayList;

public class GuQuan {
	private String corpname;
	private ArrayList<Guquanxinxi> gudongxinxi;
	private ArrayList<Guquanxinxi> comxinxi;
	public String getCorpname() {
		return corpname;
	}
	public void setCorpname(String corpname) {
		this.corpname = corpname;
	}
	public ArrayList<Guquanxinxi> getGudongxinxi() {
		return gudongxinxi;
	}
	public void setGudongxinxi(ArrayList<Guquanxinxi> gudongxinxi) {
		this.gudongxinxi = gudongxinxi;
	}
	public ArrayList<Guquanxinxi> getComxinxi() {
		return comxinxi;
	}
	public void setComxinxi(ArrayList<Guquanxinxi> comxinxi) {
		this.comxinxi = comxinxi;
	}
	public GuQuan() {
		super();
	}
	public GuQuan(String corpname, ArrayList<Guquanxinxi> gudongxinxi) {
		super();
		this.corpname = corpname;
		this.gudongxinxi = gudongxinxi;
	}
	@Override
	public String toString() {
		return "GuQuan [corpname=" + corpname + ", gudongxinxi=" + gudongxinxi + ", comxinxi=" + comxinxi + "]";
	}
	
}
