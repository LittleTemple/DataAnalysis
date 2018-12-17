package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.GuQuan;
import edu.abc.ruanjianbei.model.bean.Guquanxinxi;

public interface CompanyGuQuanDao extends BaseDao{
	

	public GuQuan Selectguquan(String comname);

	public ArrayList<Guquanxinxi> Selectcomguquan(String comname);
}
