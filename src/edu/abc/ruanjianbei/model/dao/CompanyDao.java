package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.ChildrenBean;
import edu.abc.ruanjianbei.model.bean.T_CORPBean;

public interface CompanyDao extends BaseDao{
	
	/*
	 * 通过输入的值返回匹配的公司名
	 */
	public ArrayList<T_CORPBean> selectByCompanyName(String name);
	/*
	 * 通过公司名查询公司表的信息
	 */
	public T_CORPBean searchOneCompany(int org,int id,int seq_id);
	/*
	 * 通过公司名，查找向该公司的股东
	 */
	public ArrayList<ChildrenBean> selectGuDongByCompanyName(String name,String type);
	/*
	 * 通过公司名，查找向该公司的对外投资
	 */
	public ArrayList<ChildrenBean> selectTouZiByCompanyName(String name,String type);

}
