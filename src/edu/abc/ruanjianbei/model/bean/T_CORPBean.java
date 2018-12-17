package edu.abc.ruanjianbei.model.bean;

public class T_CORPBean {

	private int ORG;
	private	int ID; 
	private	int SEQ_ID;
	private	String REG_NO;
	private	String CORP_NAME;
	private	String ADDR;
	private	String BELONG_ORG;
	private	String BELONG_DIST_ORG;
	private	String BELONG_TRADE;
	private	String ECON_KIND;
	private	String ADMIT_MAIN;
	private	String START_DATE;
	private	String CHECK_DATE;
	private	String OPER_MAN_IDENT_NO;
	private	String OPER_MAN_NAME;
	private	String CORP_STATUS;
	private	float REG_CAPI;
	private	String FARE_TERM_START;
	private	String FARE_TERM_END;
	private	String FARE_SCOPE;
	private	String UNI_SCID;
	private	String TEL;
	private	String WEB_URL;
	private	String EMAIL;
	private	int PRAC_PERSON_NUM;
	private	String ORG_INST_CODE;
	private	String TAXPAY_NUM;
	private	String STAFF_SIZE;
	private	String ENGLISH_NAME;
	private	String FORMER_NAME;
	private	String CREATE_DATE;
	private	int CREATE_ORG;
	
	public T_CORPBean() {
		super();
	}

	public T_CORPBean(int oRG, int iD, int sEQ_ID, String rEG_NO, String cORP_NAME, String aDDR, String bELONG_ORG,
			String bELONG_DIST_ORG, String bELONG_TRADE, String eCON_KIND, String aDMIT_MAIN, String sTART_DATE,
			String cHECK_DATE, String oPER_MAN_IDENT_NO, String oPER_MAN_NAME, String cORP_STATUS, float rEG_CAPI,
			String fARE_TERM_START, String fARE_TERM_END, String fARE_SCOPE, String uNI_SCID, String tEL,
			String wEB_URL, String eMAIL, int pRAC_PERSON_NUM, String oRG_INST_CODE, String tAXPAY_NUM,
			String sTAFF_SIZE, String eNGLISH_NAME, String fORMER_NAME, String cREATE_DATE, int cREATE_ORG) {
		super();
		ORG = oRG;
		ID = iD;
		SEQ_ID = sEQ_ID;
		REG_NO = rEG_NO;
		CORP_NAME = cORP_NAME;
		ADDR = aDDR;
		BELONG_ORG = bELONG_ORG;
		BELONG_DIST_ORG = bELONG_DIST_ORG;
		BELONG_TRADE = bELONG_TRADE;
		ECON_KIND = eCON_KIND;
		ADMIT_MAIN = aDMIT_MAIN;
		START_DATE = sTART_DATE;
		CHECK_DATE = cHECK_DATE;
		OPER_MAN_IDENT_NO = oPER_MAN_IDENT_NO;
		OPER_MAN_NAME = oPER_MAN_NAME;
		CORP_STATUS = cORP_STATUS;
		REG_CAPI = rEG_CAPI;
		FARE_TERM_START = fARE_TERM_START;
		FARE_TERM_END = fARE_TERM_END;
		FARE_SCOPE = fARE_SCOPE;
		UNI_SCID = uNI_SCID;
		TEL = tEL;
		WEB_URL = wEB_URL;
		EMAIL = eMAIL;
		PRAC_PERSON_NUM = pRAC_PERSON_NUM;
		ORG_INST_CODE = oRG_INST_CODE;
		TAXPAY_NUM = tAXPAY_NUM;
		STAFF_SIZE = sTAFF_SIZE;
		ENGLISH_NAME = eNGLISH_NAME;
		FORMER_NAME = fORMER_NAME;
		CREATE_DATE = cREATE_DATE;
		CREATE_ORG = cREATE_ORG;
	}

	public int getORG() {
		return ORG;
	}

	public void setORG(int oRG) {
		ORG = oRG;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getSEQ_ID() {
		return SEQ_ID;
	}

	public void setSEQ_ID(int sEQ_ID) {
		SEQ_ID = sEQ_ID;
	}

	public String getREG_NO() {
		return REG_NO;
	}

	public void setREG_NO(String rEG_NO) {
		REG_NO = rEG_NO;
	}

	public String getCORP_NAME() {
		return CORP_NAME;
	}

	public void setCORP_NAME(String cORP_NAME) {
		CORP_NAME = cORP_NAME;
	}

	public String getADDR() {
		return ADDR;
	}

	public void setADDR(String aDDR) {
		ADDR = aDDR;
	}

	public String getBELONG_ORG() {
		return BELONG_ORG;
	}

	public void setBELONG_ORG(String bELONG_ORG) {
		BELONG_ORG = bELONG_ORG;
	}

	public String getBELONG_DIST_ORG() {
		return BELONG_DIST_ORG;
	}

	public void setBELONG_DIST_ORG(String bELONG_DIST_ORG) {
		BELONG_DIST_ORG = bELONG_DIST_ORG;
	}

	public String getBELONG_TRADE() {
		return BELONG_TRADE;
	}

	public void setBELONG_TRADE(String bELONG_TRADE) {
		BELONG_TRADE = bELONG_TRADE;
	}

	public String getECON_KIND() {
		return ECON_KIND;
	}

	public void setECON_KIND(String eCON_KIND) {
		ECON_KIND = eCON_KIND;
	}

	public String getADMIT_MAIN() {
		return ADMIT_MAIN;
	}

	public void setADMIT_MAIN(String aDMIT_MAIN) {
		ADMIT_MAIN = aDMIT_MAIN;
	}

	public String getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(String sTART_DATE) {
		START_DATE = sTART_DATE;
	}

	public String getCHECK_DATE() {
		return CHECK_DATE;
	}

	public void setCHECK_DATE(String cHECK_DATE) {
		CHECK_DATE = cHECK_DATE;
	}

	public String getOPER_MAN_IDENT_NO() {
		return OPER_MAN_IDENT_NO;
	}

	public void setOPER_MAN_IDENT_NO(String oPER_MAN_IDENT_NO) {
		OPER_MAN_IDENT_NO = oPER_MAN_IDENT_NO;
	}

	public String getOPER_MAN_NAME() {
		return OPER_MAN_NAME;
	}

	public void setOPER_MAN_NAME(String oPER_MAN_NAME) {
		OPER_MAN_NAME = oPER_MAN_NAME;
	}

	public String getCORP_STATUS() {
		return CORP_STATUS;
	}

	public void setCORP_STATUS(String cORP_STATUS) {
		CORP_STATUS = cORP_STATUS;
	}

	public float getREG_CAPI() {
		return REG_CAPI;
	}

	public void setREG_CAPI(float rEG_CAPI) {
		REG_CAPI = rEG_CAPI;
	}

	public String getFARE_TERM_START() {
		return FARE_TERM_START;
	}

	public void setFARE_TERM_START(String fARE_TERM_START) {
		FARE_TERM_START = fARE_TERM_START;
	}

	public String getFARE_TERM_END() {
		return FARE_TERM_END;
	}

	public void setFARE_TERM_END(String fARE_TERM_END) {
		FARE_TERM_END = fARE_TERM_END;
	}

	public String getFARE_SCOPE() {
		return FARE_SCOPE;
	}

	public void setFARE_SCOPE(String fARE_SCOPE) {
		FARE_SCOPE = fARE_SCOPE;
	}

	public String getUNI_SCID() {
		return UNI_SCID;
	}

	public void setUNI_SCID(String uNI_SCID) {
		UNI_SCID = uNI_SCID;
	}

	public String getTEL() {
		return TEL;
	}

	public void setTEL(String tEL) {
		TEL = tEL;
	}

	public String getWEB_URL() {
		return WEB_URL;
	}

	public void setWEB_URL(String wEB_URL) {
		WEB_URL = wEB_URL;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public int getPRAC_PERSON_NUM() {
		return PRAC_PERSON_NUM;
	}

	public void setPRAC_PERSON_NUM(int pRAC_PERSON_NUM) {
		PRAC_PERSON_NUM = pRAC_PERSON_NUM;
	}

	public String getORG_INST_CODE() {
		return ORG_INST_CODE;
	}

	public void setORG_INST_CODE(String oRG_INST_CODE) {
		ORG_INST_CODE = oRG_INST_CODE;
	}

	public String getTAXPAY_NUM() {
		return TAXPAY_NUM;
	}

	public void setTAXPAY_NUM(String tAXPAY_NUM) {
		TAXPAY_NUM = tAXPAY_NUM;
	}

	public String getSTAFF_SIZE() {
		return STAFF_SIZE;
	}

	public void setSTAFF_SIZE(String sTAFF_SIZE) {
		STAFF_SIZE = sTAFF_SIZE;
	}

	public String getENGLISH_NAME() {
		return ENGLISH_NAME;
	}

	public void setENGLISH_NAME(String eNGLISH_NAME) {
		ENGLISH_NAME = eNGLISH_NAME;
	}

	public String getFORMER_NAME() {
		return FORMER_NAME;
	}

	public void setFORMER_NAME(String fORMER_NAME) {
		FORMER_NAME = fORMER_NAME;
	}

	public String getCREATE_DATE() {
		return CREATE_DATE;
	}

	public void setCREATE_DATE(String cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}

	public int getCREATE_ORG() {
		return CREATE_ORG;
	}

	public void setCREATE_ORG(int cREATE_ORG) {
		CREATE_ORG = cREATE_ORG;
	}

	@Override
	public String toString() {
		return "T_CORPBean [ORG=" + ORG + ", ID=" + ID + ", SEQ_ID=" + SEQ_ID + ", REG_NO=" + REG_NO + ", CORP_NAME="
				+ CORP_NAME + ", ADDR=" + ADDR + ", BELONG_ORG=" + BELONG_ORG + ", BELONG_DIST_ORG=" + BELONG_DIST_ORG
				+ ", BELONG_TRADE=" + BELONG_TRADE + ", ECON_KIND=" + ECON_KIND + ", ADMIT_MAIN=" + ADMIT_MAIN
				+ ", START_DATE=" + START_DATE + ", CHECK_DATE=" + CHECK_DATE + ", OPER_MAN_IDENT_NO="
				+ OPER_MAN_IDENT_NO + ", OPER_MAN_NAME=" + OPER_MAN_NAME + ", CORP_STATUS=" + CORP_STATUS
				+ ", REG_CAPI=" + REG_CAPI + ", FARE_TERM_START=" + FARE_TERM_START + ", FARE_TERM_END=" + FARE_TERM_END
				+ ", FARE_SCOPE=" + FARE_SCOPE + ", UNI_SCID=" + UNI_SCID + ", TEL=" + TEL + ", WEB_URL=" + WEB_URL
				+ ", EMAIL=" + EMAIL + ", PRAC_PERSON_NUM=" + PRAC_PERSON_NUM + ", ORG_INST_CODE=" + ORG_INST_CODE
				+ ", TAXPAY_NUM=" + TAXPAY_NUM + ", STAFF_SIZE=" + STAFF_SIZE + ", ENGLISH_NAME=" + ENGLISH_NAME
				+ ", FORMER_NAME=" + FORMER_NAME + ", CREATE_DATE=" + CREATE_DATE + ", CREATE_ORG=" + CREATE_ORG + "]";
	}

	
	
	
}
