package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.T_CORPBean;

public interface CreateDataDao extends BaseDao{
	public Boolean insertData(String sql);
	
	public ArrayList<String> searchData();

	public T_CORPBean searchOneCorp(String sql);
		
}
