package edu.abc.ruanjianbei.model.bean;

public class UserBean {
	
	private String account;
	private String nickname;
	private String password;
	private String headImg;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	public UserBean(String account, String nickname, String password, String headImg) {
		super();
		this.account = account;
		this.nickname = nickname;
		this.password = password;
		this.headImg = headImg;
	}
	public UserBean() {
		super();
	}
	@Override
	public String toString() {
		return "UserBean [account=" + account + ", nickname=" + nickname + ", password=" + password + ", headImg="
				+ headImg + "]";
	}
	
	
	
}
