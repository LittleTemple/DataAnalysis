package edu.abc.ruanjianbei.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.Links;

public class CompanyGuanXiDaoImpl extends BaseDaoImpl implements CompanyGuanXiDao{

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

	@Override
	public ArrayList<Links> selectTouZiOutside(String corpName) {
		ArrayList<Links> GuDongTouZi=new ArrayList<>();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select CORP_name,stock_name from T_CORP c,( " +
				"  select a.ORG,a.ID,a.SEQ_ID,stock_name from T_M_CORP_CORP_STOCK a,( " +
				" select distinct s.ORG,s.ID,s.SEQ_ID, s.stock_name from T_CORP_STOCK s" +
				" where  s.stock_name in( " +
				"  select b.stock_name from T_CORP a,T_CORP_STOCK b,T_M_CORP_CORP_STOCK c " +
				"  where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID and c.SUB_ID=b.ID and c.sub_org=b.org " +
				"  and c.SUB_SEQ_ID=b.SEQ_ID and b.CERTIFICATE_TYPE != 'null' and a.CORP_NAME=?) " +
				"  ) b where a.SUB_ORG=b.ORG and a.SUB_ID=b.ID and a.SUB_SEQ_ID=b.SEQ_ID " +
				"  ) d where c.ORG=d.ORG and c.ID=d.ID and c.SEQ_ID=c.SEQ_ID";
		Connection conn=BaseDaoImpl.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, corpName);
			rs=pst.executeQuery();
			while(rs.next()) {
				String CORP_NAME=rs.getString("CORP_NAME");
				String STOCK_NAME=rs.getString("STOCK_NAME");
				Links links=new Links(STOCK_NAME, CORP_NAME, "???");
				GuDongTouZi.add(links);
			}
			System.out.println("selectTouZiOutside  "+GuDongTouZi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			BaseDaoImpl.close(conn, pst, rs);
		}
		return GuDongTouZi;
	}

	@Override
	public ArrayList<Links> selectRenZhiOutside(String corpName, String sql) {
		ArrayList<Links> RenZhi=new ArrayList<>();
		PreparedStatement pst=null;
		ResultSet rs=null;
		Connection conn=BaseDaoImpl.getConnection();
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, corpName);
			rs=pst.executeQuery();
			while(rs.next()) {
				String CORP_NAME=rs.getString("CORP_NAME");
				String PERSON_NAME=rs.getString("PERSON_NAME");
				String PERSON_TYPE=rs.getString("PERSON_TYPE");
				Links links=new Links(PERSON_NAME, CORP_NAME, PERSON_TYPE);
				RenZhi.add(links);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			BaseDaoImpl.close(conn, pst, rs);
		}
		return RenZhi;
	}

	@Override
	public ArrayList<Links> selectGuDongRenZhiOutside(String corpName) {
		ArrayList<Links> GuDongRenZhi=new ArrayList<>();
		String sql="select CORP_name,person_name ,person_type from T_CORP c,( " +
				"select a.ORG,a.ID,a.SEQ_ID ,person_name ,person_type from T_M_CORP_CORP_PERTAINS a,( " +
				" select pe.ORG,pe.ID,pe.SEQ_ID, pe.person_name ,pe.person_type from T_CORP_PERTAINS pe where pe.person_name in( " +
				" select stock_name from T_CORP a,T_CORP_STOCK b,T_M_CORP_CORP_STOCK c " + 
				"  where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID and c.SUB_ID=b.ID and c.sub_org=b.org " +
				"  and c.SUB_SEQ_ID=b.SEQ_ID and b.CERTIFICATE_TYPE != 'null' and a.CORP_NAME=?) " +
				") b where a.SUB_ORG=b.ORG and a.SUB_ID=b.ID and a.SUB_SEQ_ID=b.SEQ_ID " +
				") d where c.ORG=d.ORG and c.ID=d.ID and c.SEQ_ID=c.SEQ_ID";
		GuDongRenZhi=selectRenZhiOutside(corpName,sql);
		return GuDongRenZhi;
	}

	@Override
	public ArrayList<Links> selectGaoGuanRenZhiOutside(String corpName) {
		ArrayList<Links> GaoGuanRenZhi=new ArrayList<>();
		String sql="select CORP_name,person_name ,person_type from T_CORP c,( " + 
				"select a.ORG,a.ID,a.SEQ_ID ,person_name ,person_type from T_M_CORP_CORP_PERTAINS a,( " +
				" select ORG,ID,SEQ_ID, person_name ,person_type from T_CORP_PERTAINS where person_name in( " +
				"select person_name from T_CORP a,T_CORP_PERTAINS b,T_M_CORP_CORP_PERTAINS c where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID and c.SUB_ID=b.ID and c.sub_org=b.org " +
				" and c.SUB_SEQ_ID=b.SEQ_ID and a.CORP_NAME=?) " +
				") b where a.SUB_ORG=b.ORG and a.SUB_ID=b.ID and a.SUB_SEQ_ID=b.SEQ_ID " +
				") d where c.ORG=d.ORG and c.ID=d.ID and c.SEQ_ID=d.SEQ_ID";
		GaoGuanRenZhi=selectRenZhiOutside(corpName,sql);
		return GaoGuanRenZhi;
	}

}
