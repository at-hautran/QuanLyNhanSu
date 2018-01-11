package com.cham.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.cham.DBConnect.DBConnect;
import com.cham.bean.Staff;
import com.cham.bean.Teacher;
import com.cham.bean.User;

public class UserDao {
	
	public boolean checklogin(String name,String password) {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM User WHERE Username ='"+name+"' and Password = '" +password+ "'";
		PreparedStatement ps;
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				conn.close();
				return true;
			}
			
		}catch (SQLException ex) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,ex);
		}
			return false;
		
	}
	public int checkID(String name) {
		Integer vaitro=0;
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM User WHERE Username ='"+name+"'";
		try {
			Statement stm = conn.createStatement();
			stm.execute(sql);
			ResultSet rs = stm.getResultSet();
			if(rs.next()) {
				vaitro = rs.getInt("Role");
			}
		}catch (SQLException ex) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,ex);
		}
		return vaitro;
	}
	public ArrayList<User> getListUsers() {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM User ";
		PreparedStatement ps;
		ArrayList<User> listUser = new ArrayList<>();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				User objUser = new User(rs.getInt("UserId"),rs.getString("Username"), rs.getString("Password"),rs.getInt("Role"), rs.getInt("type"));
				listUser.add(objUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	}
	public User getUserByUsername(String username) {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM User WHERE Username = '"+username+"'";
		PreparedStatement ps;
		User objUser = new User();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				 objUser = new User(rs.getInt("UserId"),rs.getString("Username"), rs.getString("Password"),rs.getInt("Role"), rs.getInt("type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return objUser;
	}
	
	public static User getUserById(int userId) {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM User WHERE UserId = '"+userId+"'";
		PreparedStatement ps;
		User user = null;
		//Staff staff = new Staff();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			user = new User(rs.getInt("UserId"), rs.getString("Username"), rs.getString("Password"), rs.getInt("Role"), rs.getInt("Type"));
			
		}} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
}