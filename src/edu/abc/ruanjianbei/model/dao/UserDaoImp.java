package edu.abc.ruanjianbei.model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.abc.ruanjianbei.model.bean.UserBean;

public class UserDaoImp extends BaseDaoImpl implements UserDao{

	@Override
	public Boolean add(Object o) {
		// TODO Auto-generated method stub
		UserBean user=(UserBean)o;
		boolean result=false;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Connection conn=BaseDaoImpl.getConnection();
		try {
			pst=conn.prepareStatement("insert into users(account,password) values('"+user.getAccount()+"','"+user.getPassword()+"')");
			int count=pst.executeUpdate();
			result=(count>0)?true:false;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			BaseDaoImpl.close(conn, pst, rs);
		}
		return result;
	}

	@Override
	public Boolean delete(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBean login(String account, String password) {
		// TODO Auto-generated method stub
		System.out.println(account);
		System.out.println(password);
		// TODO Auto-generated method stub
		PreparedStatement sta=null;
		ResultSet res=null;
		Connection conn=BaseDaoImpl.getConnection();
		try {
			
			sta=conn.prepareStatement("select * from users where account=? and password=?");
			sta.setString(1, account);
			sta.setString(2, password);
			res=sta.executeQuery();
			while(res.next()) {
				UserBean user=new UserBean();
				user.setAccount(res.getString("account"));
				user.setNickname(res.getString("nickname"));
				user.setPassword(res.getString("password"));
				user.setHeadImg(res.getString("headImg"));
				System.out.println(user);
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDaoImpl.close(conn, sta, res);
		}
		return null;
	}

	@Override
	public boolean checkUserExist(String account) {
		// TODO Auto-generated method stub
		boolean result=false;
		Statement sta=null;
		Connection conn=BaseDaoImpl.getConnection();
		try {
			sta=conn.createStatement();
			ResultSet rs=sta.executeQuery("select count(account) from users where account='"+account+"'");
			rs.next();
			result=(rs.getInt(1)>0)?true:false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}


}
