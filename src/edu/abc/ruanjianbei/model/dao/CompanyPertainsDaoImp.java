package edu.abc.ruanjianbei.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.ChildrenBean;

public class CompanyPertainsDaoImp extends BaseDaoImpl implements CompanyPertainsDao{

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
	 */
	@Override
	public ArrayList<ChildrenBean> selectMemberByCompany(String type, String corpName, int org, int seq_id) {

		// TODO Auto-generated method stub

		ArrayList<ChildrenBean> corpMember=new ArrayList<>();
		PreparedStatement pst=null;
		ResultSet rs=null;
		String selectType=type;
		Connection conn=BaseDaoImpl.getConnection();
		String sql="select corp_name,PERSON_NAME from T_CORP a,T_CORP_PERTAINS b,T_M_CORP_CORP_PERTAINS c" + 
				" where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID " + 
				" and c.SUB_ID=b.ID and c.sub_org=b.org and c.SUB_SEQ_ID=b.SEQ_ID and a.ORG=? and a.seq_id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, org);
			pst.setInt(2, seq_id);
			rs=pst.executeQuery();
			while(rs.next()) {
				String PERSON_NAME=rs.getString("PERSON_NAME");
				ChildrenBean childrenData=new ChildrenBean(PERSON_NAME,selectType,"");
				corpMember.add(childrenData);
			}
			System.out.println(""+corpMember);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return corpMember;
	}

}
