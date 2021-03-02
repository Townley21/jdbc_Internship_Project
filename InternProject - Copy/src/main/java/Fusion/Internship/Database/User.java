package Fusion.Internship.Database;

import java.sql.Timestamp;
import java.util.Date;

public class User {
	Date date = new Date();
	long time = date.getTime();
	
	private int loginID;
	//private String username;
	private String email;
	private Timestamp lastLogin = new Timestamp(time);
	private String password;
	
	public User(int loginID, String email, String password, Timestamp lastLogin) {
		//this.username = username;
		this.email = email;
		this.loginID = loginID;
		this.password = password;
		this.lastLogin = lastLogin;
	}
	
	public int getLoginID() {
		return loginID;
	}
	
	public void setLoginID(int loginID) {
		this.loginID = loginID;
	}
	
	//public String getUsername() {
	//	return username;
	//}
	
	//public void setUsername(String username) {
	//	this.username = username;
	//}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Timestamp getLastLogin() {
		return lastLogin;
	}
	
	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

}
