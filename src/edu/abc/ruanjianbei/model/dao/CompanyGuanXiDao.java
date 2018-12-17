package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.Links;

public interface CompanyGuanXiDao extends BaseDao{

	public ArrayList<Links> selectTouZiOutside(String corpName);
	public ArrayList<Links> selectRenZhiOutside(String corpName,String sql);

	public ArrayList<Links> selectGuDongRenZhiOutside(String corpName);

	public ArrayList<Links> selectGaoGuanRenZhiOutside(String corpName);
}
