package edu.abc.ruanjianbei.model.dao;

import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.ChildrenBean;

public interface CompanyPertainsDao extends BaseDao{

	public ArrayList<ChildrenBean> selectMemberByCompany(String type, String corpName, int org, int seq_id);
}
