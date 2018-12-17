package edu.abc.ruanjianbei.model.bean;

public class T_CORP_STOCKBean {

	private int ORG;
	private int ID;
	private int SEQ_ID;
	private String STOCK_TYPE;
	private String COUNTRY;
	private String CERTIFICATE_TYPE;
	private String CERTIFICATE_NO;
	private String STOCK_NAME;
	private String STOCK_CAPI_TYPE;
	private float STOCK_CAPI;
	private float STOCK_CAPI_DOLLAR;
	private float STOCK_CAPI_RMB;
	private String STOCK_PERCENT;
	private float STOCK_RATE_RMB;
	private float STOCK_RATE_DOLLAR;
	private String CREATE_DATE;	
	
	@Override
	public String toString() {
		return "T_CORP_STOCKBean [ORG=" + ORG + ", ID=" + ID + ", SEQ_ID=" + SEQ_ID + ", STOCK_TYPE=" + STOCK_TYPE
				+ ", COUNTRY=" + COUNTRY + ", CERTIFICATE_TYPE=" + CERTIFICATE_TYPE + ", CERTIFICATE_NO="
				+ CERTIFICATE_NO + ", STOCK_NAME=" + STOCK_NAME + ", STOCK_CAPI_TYPE=" + STOCK_CAPI_TYPE
				+ ", STOCK_CAPI=" + STOCK_CAPI + ", STOCK_CAPI_DOLLAR=" + STOCK_CAPI_DOLLAR + ", STOCK_CAPI_RMB="
				+ STOCK_CAPI_RMB + ", STOCK_PERCENT=" + STOCK_PERCENT + ", STOCK_RATE_RMB=" + STOCK_RATE_RMB
				+ ", STOCK_RATE_DOLLAR=" + STOCK_RATE_DOLLAR + ", CREATE_DATE=" + CREATE_DATE + "]";
	}


	public T_CORP_STOCKBean(int oRG, int iD, int sEQ_ID, String sTOCK_TYPE, String cOUNTRY, String cERTIFICATE_TYPE,
			String cERTIFICATE_NO, String sTOCK_NAME, String sTOCK_CAPI_TYPE, int sTOCK_CAPI, float sTOCK_CAPI_DOLLAR,
			int sTOCK_CAPI_RMB, String sTOCK_PERCENT, float sTOCK_RATE_RMB, float sTOCK_RATE_DOLLAR,
			String cREATE_DATE) {
		super();
		ORG = oRG;
		ID = iD;
		SEQ_ID = sEQ_ID;
		STOCK_TYPE = sTOCK_TYPE;
		COUNTRY = cOUNTRY;
		CERTIFICATE_TYPE = cERTIFICATE_TYPE;
		CERTIFICATE_NO = cERTIFICATE_NO;
		STOCK_NAME = sTOCK_NAME;
		STOCK_CAPI_TYPE = sTOCK_CAPI_TYPE;
		STOCK_CAPI = sTOCK_CAPI;
		STOCK_CAPI_DOLLAR = sTOCK_CAPI_DOLLAR;
		STOCK_CAPI_RMB = sTOCK_CAPI_RMB;
		STOCK_PERCENT = sTOCK_PERCENT;
		STOCK_RATE_RMB = sTOCK_RATE_RMB;
		STOCK_RATE_DOLLAR = sTOCK_RATE_DOLLAR;
		CREATE_DATE = cREATE_DATE;
	}
	
	
	public T_CORP_STOCKBean() {
		super();
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
	public String getSTOCK_TYPE() {
		return STOCK_TYPE;
	}
	public void setSTOCK_TYPE(String sTOCK_TYPE) {
		STOCK_TYPE = sTOCK_TYPE;
	}
	public String getCOUNTRY() {
		return COUNTRY;
	}
	public void setCOUNTRY(String cOUNTRY) {
		COUNTRY = cOUNTRY;
	}
	public String getCERTIFICATE_TYPE() {
		return CERTIFICATE_TYPE;
	}
	public void setCERTIFICATE_TYPE(String cERTIFICATE_TYPE) {
		CERTIFICATE_TYPE = cERTIFICATE_TYPE;
	}
	public String getCERTIFICATE_NO() {
		return CERTIFICATE_NO;
	}
	public void setCERTIFICATE_NO(String cERTIFICATE_NO) {
		CERTIFICATE_NO = cERTIFICATE_NO;
	}
	public String getSTOCK_NAME() {
		return STOCK_NAME;
	}
	public void setSTOCK_NAME(String sTOCK_NAME) {
		STOCK_NAME = sTOCK_NAME;
	}
	public String getSTOCK_CAPI_TYPE() {
		return STOCK_CAPI_TYPE;
	}
	public void setSTOCK_CAPI_TYPE(String sTOCK_CAPI_TYPE) {
		STOCK_CAPI_TYPE = sTOCK_CAPI_TYPE;
	}
	
	public float getSTOCK_CAPI() {
		return STOCK_CAPI;
	}

	public void setSTOCK_CAPI(float sTOCK_CAPI) {
		STOCK_CAPI = sTOCK_CAPI;
	}


	public float getSTOCK_CAPI_DOLLAR() {
		return STOCK_CAPI_DOLLAR;
	}
	public void setSTOCK_CAPI_DOLLAR(float sTOCK_CAPI_DOLLAR) {
		STOCK_CAPI_DOLLAR = sTOCK_CAPI_DOLLAR;
	}
	public float getSTOCK_CAPI_RMB() {
		return STOCK_CAPI_RMB;
	}


	public void setSTOCK_CAPI_RMB(float sTOCK_CAPI_RMB) {
		STOCK_CAPI_RMB = sTOCK_CAPI_RMB;
	}


	public String getSTOCK_PERCENT() {
		return STOCK_PERCENT;
	}
	public void setSTOCK_PERCENT(String sTOCK_PERCENT) {
		STOCK_PERCENT = sTOCK_PERCENT;
	}
	public float getSTOCK_RATE_RMB() {
		return STOCK_RATE_RMB;
	}
	public void setSTOCK_RATE_RMB(float sTOCK_RATE_RMB) {
		STOCK_RATE_RMB = sTOCK_RATE_RMB;
	}
	public float getSTOCK_RATE_DOLLAR() {
		return STOCK_RATE_DOLLAR;
	}
	public void setSTOCK_RATE_DOLLAR(float sTOCK_RATE_DOLLAR) {
		STOCK_RATE_DOLLAR = sTOCK_RATE_DOLLAR;
	}
	public String getCREATE_DATE() {
		return CREATE_DATE;
	}
	public void setCREATE_DATE(String cREATE_DATE) {
		CREATE_DATE = cREATE_DATE;
	}
	
	
	
	
}
