package edu.abc.ruanjianbei.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import edu.abc.ruanjianbei.model.bean.T_CORPBean;

public class CreateDataDaoImp extends BaseDaoImpl implements CreateDataDao{

	@Override
	public Boolean add(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Object o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Object o) {
		// TODO Auto-generated method stub
		String sql=(String)o;
		System.out.println(""+sql);
		Statement sta=null;
		ResultSet rs=null;
		Connection conn=BaseDaoImpl.getConnection();
		
		try {
			sta=conn.createStatement();
			int result=sta.executeUpdate(sql);
			return result>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDaoImpl.close(conn, sta, rs);
		}
		return true;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean insertData(String sql) {
		System.out.println(""+sql);
		Statement sta=null;
		ResultSet rs=null;
		Connection conn=BaseDaoImpl.getConnection();
		
		try {
			sta=conn.createStatement();
			int result=sta.executeUpdate(sql);
			
			return result>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDaoImpl.close(conn, sta, rs);
		}
		return true;
	}
	/*
	 *
	 * (non-Javadoc)
	 * @see edu.abc.ruanjianbei.model.dao.CreateDataDao#searchData(java.lang.String)
	 */
	public ArrayList<String> searchData() {
		ArrayList<String> corp=new ArrayList<>();
		PreparedStatement pst=null;
		ResultSet rs=null;
		Connection conn=BaseDaoImpl.getConnection();
		Random random=new Random();
		int num=random.nextInt(3)+1;
		String sql="select CORP_NAME FROM(select CORP_NAME from T_CORP ORDER by dbms_random.value) WHERE rownum<"+num;
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				corp.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDaoImpl.close(conn, pst, rs);
		}
		return corp;
	}
	
	@Override
	public T_CORPBean searchOneCorp(String sql) {
		// TODO Auto-generated method stub
		T_CORPBean oneCorp=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Connection conn=BaseDaoImpl.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				oneCorp=new T_CORPBean();
				oneCorp.setORG(rs.getInt("ORG"));
				oneCorp.setID(rs.getInt("ID"));
				oneCorp.setSEQ_ID(rs.getInt("SEQ_ID"));
				oneCorp.setCORP_NAME(rs.getString("CORP_NAME"));
				oneCorp.setCREATE_DATE(rs.getString("CREATE_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			BaseDaoImpl.close(conn, pst, rs);
		}
		return oneCorp;
	}
	
	public static void main(String[] args) {
		CreateDataDaoImp cd=new CreateDataDaoImp();
		for(int i=1;i<10;i++) {
			//int j=i-1;
			System.out.println(cd.searchData());
		//	System.out.println(cd.searchOneCorp("SELECT * from T_CORP WHERE rownum<="+i+" minus (SELECT * from T_CORP WHERE rownum<="+j+")"));
		}
		
	}


}
