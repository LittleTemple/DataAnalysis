package edu.abc.ruanjianbei.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.GuQuan;
import edu.abc.ruanjianbei.model.bean.Guquanxinxi;

public class CompanyGuQuanDaoImpl extends BaseDaoImpl implements CompanyGuQuanDao{

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
		return null;
	}

	@Override
	public Object list() {
		// TODO Auto-generated method stub
		return null;
	}
	/*
	 *
	 * @see edu.abc.ruanjianbei.model.dao.CompanyGuQuanDao#Selectguquan(java.lang.String)
	 */
	@Override
	public GuQuan Selectguquan(String comname) {
		ArrayList<Guquanxinxi> xinxi=new ArrayList<>();
		GuQuan guquanxingxi=new GuQuan();
		PreparedStatement pst=null;
		ResultSet rs=null;
		Connection conn=BaseDaoImpl.getConnection();
		String sql="select stock_name,stock_percent,STOCK_CAPI from T_CORP a,T_CORP_STOCK b,T_M_CORP_CORP_STOCK c " + 
				"        where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID and c.SUB_ID=b.ID and c.sub_org=b.org " +
				"            and c.SUB_SEQ_ID=b.SEQ_ID and b.CERTIFICATE_TYPE !='null' and a.CORP_NAME=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, comname);
			rs=pst.executeQuery();
			while(rs.next()) {
				String stock_name=rs.getString("STOCK_NAME");
				String stock_percent=rs.getString("STOCK_PERCENT");
				String stock_capi=rs.getString("STOCK_CAPI");
				Guquanxinxi gx=new Guquanxinxi(stock_name, stock_percent, stock_capi);
				xinxi.add(gx);
			}
			guquanxingxi.setCorpname(comname);
			guquanxingxi.setGudongxinxi(xinxi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			BaseDaoImpl.close(conn, pst, rs);
		}
		return guquanxingxi;
	}
	/*
	 *
	 * @see edu.abc.ruanjianbei.model.dao.CompanyGuQuanDao#Selectcomguquan(java.lang.String)
	 */
	@Override
	public ArrayList<Guquanxinxi> Selectcomguquan(String comname) {
		ArrayList<Guquanxinxi> comxinxi=new ArrayList<>();
		PreparedStatement pst=null;
		ResultSet rs=null;
		Connection conn=BaseDaoImpl.getConnection();
		String sql="select stock_name,stock_percent,STOCK_CAPI from T_CORP a,T_CORP_STOCK b,T_M_CORP_CORP_STOCK c " + 
				"        where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID and c.SUB_ID=b.ID and c.sub_org=b.org " +
				"            and c.SUB_SEQ_ID=b.SEQ_ID and b.CERTIFICATE_TYPE ='null' and a.CORP_NAME=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, comname);
			rs=pst.executeQuery();
			while(rs.next()) {
				String stock_name=rs.getString("STOCK_NAME");
				String stock_percent=rs.getString("STOCK_PERCENT");
				String stock_capi=rs.getString("STOCK_CAPI");
				Guquanxinxi gx=new Guquanxinxi(stock_name, stock_percent, stock_capi);
				comxinxi.add(gx);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			BaseDaoImpl.close(conn, pst, rs);
		}
		return comxinxi;
	}
	
}
