package Fusion.Internship.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import Fusion.Internship.Database.User;


public class BasicDAOImpl implements BasicDAO {
	private static Connection conn = conn();
	
	public static Connection conn() {
		try {
			return dbManager.openConnection();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public BasicDAOImpl (User user) {
		return;
	}
	
	
	public User insertUser(User user) {
		int loginID = user.getLoginID();
		String Email = user.getEmail();
		String Password = user.getPassword();
		Timestamp lastLogin = user.getLastLogin();
		
		String sql = "INSERT INTO sys.login_info VALUES(?,?,?,?)";
		PreparedStatement myStmt = conn.prepareStatement(sql);
		
		myStmt.setInt(1, loginID);
		myStmt.setString(2, Email);
		myStmt.setTimestamp(3, lastLogin);
		myStmt.setString(4,Password);
		
		try {
		myStmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}


	public User getUser(User user) {
		
		String sql = "SELECT * FROM sys.login_info WHERE email = '" + user.getLoginID() + "'";
		PreparedStatement myStmt = conn.prepareStatement(sql);
		ResultSet rs = myStmt.executeQuery(sql);
		
		rs.beforeFirst();
		rs.next();
		int ID = rs.getInt("login_id");
		String email = rs.getString("email");
		String password = rs.getString("password");
		Timestamp lastlogin = rs.getTimestamp("last_login");
		
		User newUser = new User(ID, email, password, lastlogin);
		return newUser;
	}


	public void updateUser(User user) {
		
		String sql = "UPDATE sys.login_info /nSET email = " + user.getEmail() + "WHERE login_id = " + user.getLoginID();
		PreparedStatement myStmt = conn.prepareStatement(sql);
		
		try {
		myStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("User could not be updated");
		}
		
	}


	public void deleteUser(User user) {
		
		String sql = "DELETE FROM sys.login_info WHERE login_id = '" + user.getLoginID() + "'";
		PreparedStatement myStmt = conn.prepareStatement(sql);
		
		try {
		myStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void printUser(User user) throws Exception {
		
		String sql = "SELECT " + user.getLoginID() + "PRINT sys.login_ID/nPRINT email/nPRINT last_login/nPRINT password";
		PreparedStatement myStmt = conn.prepareStatement(sql);
		
		try {
		myStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

