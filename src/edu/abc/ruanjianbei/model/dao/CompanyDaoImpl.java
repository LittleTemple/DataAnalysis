package edu.abc.ruanjianbei.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.abc.ruanjianbei.model.bean.ChildrenBean;
import edu.abc.ruanjianbei.model.bean.T_CORPBean;

public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao {

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
     * 根据输入的值模糊匹配公司名
     */
    @Override
    public ArrayList<T_CORPBean> selectByCompanyName(String name) {
        ArrayList<T_CORPBean > companys=new ArrayList<>();
        StringBuffer sql=new StringBuffer();
        PreparedStatement pst=null;
        ResultSet rs=null;
        sql.append(" select CORP_NAME,ORG,ID,SEQ_ID from T_CORP ");
        sql.append(" where CORP_NAME like ? ");
        Connection conn=BaseDaoImpl.getConnection();
        try {
            pst=conn.prepareStatement(sql.toString());
            pst.setString(1, "%"+name+"%");
            rs=pst.executeQuery();
            while(rs.next()) {
                String companyname=rs.getString("CORP_NAME");
                T_CORPBean company=new T_CORPBean();
                company.setCORP_NAME(companyname);
                company.setORG(rs.getInt("ORG"));
                company.setID(rs.getInt("ID"));
                company.setSEQ_ID(rs.getInt("SEQ_ID"));
                companys.add(company);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }finally {
            BaseDaoImpl.close(conn, pst, rs);
        }
        return companys;
    }
    /*
     * 根据输入的公司名查询公司表信息
     */
    @Override
    public T_CORPBean searchOneCompany(int org,int id,int seq_id) {
        T_CORPBean company = null;
        StringBuffer sql=new StringBuffer();
        PreparedStatement pst=null;
        ResultSet rs=null;
        sql.append(" select * from T_CORP ");
        sql.append(" where ORG=? and ID=? and SEQ_ID=?");
        Connection conn=BaseDaoImpl.getConnection();
        try {
            pst=conn.prepareStatement(sql.toString());
            pst.setInt(1, org);
            pst.setInt(2, id);
            pst.setInt(3, seq_id);
            rs=pst.executeQuery();
            while(rs.next()) {
                int ORG=rs.getInt("ORG");
                int ID=rs.getInt("ID");
                int SEQ_ID=rs.getInt("SEQ_ID");
                String REG_NO=rs.getString("REG_NO");
                String CORP_NAME=rs.getString("CORP_NAME");
                String ADDR=rs.getString("ADDR");
                String BELONG_ORG=rs.getString("BELONG_ORG");
                String BELONG_DIST_ORG=rs.getString("BELONG_DIST_ORG");
                String BELONG_TRADE=rs.getString("BELONG_TRADE");
                String ECON_KIND=rs.getString("ECON_KIND");
                String ADMIT_MAIN=rs.getString("ADMIT_MAIN");
                String START_DATE=rs.getString("START_DATE");
                String CHECK_DATE=rs.getString("CHECK_DATE");
                String OPER_MAN_IDENT_NO=rs.getString("OPER_MAN_IDENT_NO");
                String OPER_MAN_NAME=rs.getString("OPER_MAN_NAME");
                String CORP_STATUS=rs.getString("CORP_STATUS");
                float REG_CAPI=rs.getFloat("REG_CAPI");
                String FARE_TERM_START=rs.getString("FARE_TERM_START");
                String FARE_TERM_END=rs.getString("FARE_TERM_END");
                String FARE_SCOPE=rs.getString("FARE_SCOPE");
                String UNI_SCID=rs.getString("UNI_SCID");
                String TEL=rs.getString("TEL");
                String WEB_URL=rs.getString("WEB_URL");
                String EMAIL=rs.getString("EMAIL");
                int PRAC_PERSON_NUM=rs.getInt("PRAC_PERSON_NUM");
                String ORG_INST_CODE=rs.getString("ORG_INST_CODE");
                String TAXPAY_NUM=rs.getString("TAXPAY_NUM");
                String STAFF_SIZE=rs.getString("STAFF_SIZE");
                String ENGLISH_NAME=rs.getString("ENGLISH_NAME");
                String FORMER_NAME=rs.getString("FORMER_NAME");
                String CREATE_DATE=rs.getString("CREATE_DATE");
                int CREATE_ORG=rs.getInt("CREATE_ORG");

                company=new T_CORPBean();
                company.setORG(ORG);
                company.setID(ID);
                company.setSEQ_ID(SEQ_ID);
                company.setREG_NO(REG_NO);
                company.setCORP_NAME(CORP_NAME);
                company.setADDR(ADDR);
                company.setBELONG_ORG(BELONG_ORG);
                company.setBELONG_DIST_ORG(BELONG_DIST_ORG);
                company.setBELONG_TRADE(BELONG_TRADE);
                company.setECON_KIND(ECON_KIND);
                company.setADMIT_MAIN(ADMIT_MAIN);
                company.setSTART_DATE(START_DATE);
                company.setCHECK_DATE(CHECK_DATE);
                company.setOPER_MAN_IDENT_NO(OPER_MAN_IDENT_NO);
                company.setOPER_MAN_NAME(OPER_MAN_NAME);
                company.setCORP_STATUS(CORP_STATUS);
                company.setREG_CAPI(REG_CAPI);
                company.setFARE_TERM_START(FARE_TERM_START);
                company.setFARE_TERM_END(FARE_TERM_END);
                company.setFARE_SCOPE(FARE_SCOPE);
                company.setUNI_SCID(UNI_SCID);
                company.setTEL(TEL);
                company.setWEB_URL(WEB_URL);
                company.setEMAIL(EMAIL);
                company.setPRAC_PERSON_NUM(PRAC_PERSON_NUM);
                company.setORG_INST_CODE(ORG_INST_CODE);
                company.setTAXPAY_NUM(TAXPAY_NUM);
                company.setSTAFF_SIZE(STAFF_SIZE);
                company.setENGLISH_NAME(ENGLISH_NAME);
                company.setFORMER_NAME(FORMER_NAME);
                company.setCREATE_DATE(CREATE_DATE);
                company.setCREATE_ORG(CREATE_ORG);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }finally {
            BaseDaoImpl.close(conn, pst, rs);
        }
        return company;
    }

    /*
     * 通过公司名，查找向该公司投资的股东
     */
    public ArrayList<ChildrenBean> selectGuDongByCompanyName(String type,String name){
        ArrayList<ChildrenBean> GuDongRen=new ArrayList<>();
        PreparedStatement pst=null;
        ResultSet rs=null;
        String selectType=type;
        Connection conn=BaseDaoImpl.getConnection();
        String sql="select STOCK_NAME,STOCK_PERCENT from T_CORP a,T_CORP_STOCK b,T_M_CORP_CORP_STOCK c " +
                " where a.org=c.ORG and a.id=c.ID and a.seq_id=c.SEQ_ID and c.SUB_ID=b.ID and c.sub_org=b.org " +
                " and c.SUB_SEQ_ID=b.SEQ_ID and a.CORP_NAME=?";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, name);
            rs=pst.executeQuery();
            while(rs.next()) {
                String STOCK_NAME=rs.getString("STOCK_NAME");
                String STOCK_PERCENT=rs.getString("STOCK_PERCENT");
                ChildrenBean children=new ChildrenBean(STOCK_NAME,selectType,STOCK_PERCENT);
                GuDongRen.add(children);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }finally {
            BaseDaoImpl.close(conn, pst, rs);
        }
        return GuDongRen;
    }
    /*
     * 通过公司名，查找向该公司的对外投资
     */
    public ArrayList<ChildrenBean> selectTouZiByCompanyName(String type,String name){
        ArrayList<ChildrenBean> GuDongCom=new ArrayList<>();
        PreparedStatement pst=null;
        ResultSet rs=null;
        String selectType=type;
        Connection conn=BaseDaoImpl.getConnection();
        String sql="select CORP_name,stock_percent from T_CORP c,( " +
                " select a.ORG,a.ID,a.SEQ_ID,stock_percent from T_M_CORP_CORP_STOCK a,( " +
                " select distinct s.ORG,s.ID,s.SEQ_ID,s.stock_percent from T_CORP_STOCK s" +
                " where s.CERTIFICATE_TYPE = 'null' and s.stock_name=? " +
                " ) b where a.SUB_ORG=b.ORG and a.SUB_ID=b.ID and a.SUB_SEQ_ID=b.SEQ_ID " +
                "  ) d where c.ORG=d.ORG and c.ID=d.ID and c.SEQ_ID=c.SEQ_ID";
        System.out.println("selectGuDongCom   "+sql);
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, name);
            rs=pst.executeQuery();
            while(rs.next()) {
                String CORP_NAME=rs.getString("CORP_NAME");
                String STOCK_PERCENT=rs.getString("STOCK_PERCENT");
                ChildrenBean childrenData=new ChildrenBean(CORP_NAME,selectType,STOCK_PERCENT);
                GuDongCom.add(childrenData);
            }
            System.out.println("查出来的对外投资   "+GuDongCom);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return GuDongCom;
    }

}
