package vn.iotstar.model;

import java.io.Serializable;

public class UserModel implements Serializable{
	private int id;
	private String userName;
	private String fullName;
	private String passWord;
	private int Roleid;
	
	
	public UserModel() {
		super();
	}
	
	public UserModel(int id, String roleid, String userName, String fullName, String passWord) {
		super();
		this.id = id;
		this.userName = userName;
		this.fullName = fullName;
		this.passWord = passWord;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	
}
