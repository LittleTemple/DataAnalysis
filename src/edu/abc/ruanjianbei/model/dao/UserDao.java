package edu.abc.ruanjianbei.model.dao;

import edu.abc.ruanjianbei.model.bean.UserBean;

public interface UserDao extends BaseDao {
	
	public UserBean login(String account, String password);
	public boolean checkUserExist(String account);

}
