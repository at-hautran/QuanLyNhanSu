package com.cham.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cham.DBConnect.DBConnect;
import com.cham.bean.Staff;
import com.cham.bean.Teacher;

public class TeacherDao {
	public ArrayList<Teacher> getListTeachers() {
		System.out.print("as1");
		Connection conn = DBConnect.getConnecttion();
		System.out.print("as2");
		String sql ="SELECT * FROM Teacher ";
		PreparedStatement ps;
		ArrayList<Teacher> listTeacher = new ArrayList<>();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.print("as");
				
				Teacher objTeacher = new Teacher(rs.getInt("UserId"),rs.getString("Name"), rs.getInt("BirthYear"),
						rs.getString("Faculty"),rs.getInt("Lessons"),rs.getFloat("CoefficientSalary"),rs.getString("Degree"),
						rs.getString("Country"),rs.getInt("Allowance"),rs.getInt("Salary"));
				listTeacher.add(objTeacher);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listTeacher;
	}

public static Teacher getTeacher(int userId) {
	Connection conn = DBConnect.getConnecttion();
	String sql ="SELECT * FROM Teacher WHERE UserId = '"+userId+"'";
	PreparedStatement ps;
	Teacher teacher = null;
	//Staff staff = new Staff();
	try {
		ps = conn.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
		teacher = new Teacher(rs.getInt("UserId"),rs.getString("Name"), rs.getInt("BirthYear"),
				rs.getString("Faculty"),rs.getInt("Lessons"),rs.getFloat("CoefficientSalary"),
				rs.getString("Degree"),rs.getString("Country"),rs.getInt("Allowance"),rs.getInt("Salary"));
		
	}} catch (SQLException e) {
		e.printStackTrace();
	}
	return teacher;
}
public static Teacher getTeacherAndUserInforByUserId(int userId) {
	System.out.print("user_id" + userId);
	Connection conn = DBConnect.getConnecttion();
	String sql = "SELECT * FROM Teacher INNER JOIN User ON Teacher.UserId = User.UserId WHERE Teacher.UserId = '" + userId + "'";
	PreparedStatement ps;
	Teacher teacher = null;
	//Staff staff = new Staff();
	try {
		ps = conn.prepareCall(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
		teacher = new Teacher(rs.getInt("UserId"), rs.getString("Username"), rs.getString("Password"),
				rs.getInt("role"), rs.getInt("type"), rs.getString("Name"), rs.getInt("BirthYear"),
				rs.getString("Faculty"),rs.getInt("Lessons"),rs.getFloat("CoefficientSalary"),
				rs.getString("Degree"),rs.getString("Country"),rs.getInt("Allowance"),rs.getInt("Salary"));
		
	}} catch (SQLException e) {
		e.printStackTrace();
	}
	return teacher;	
}
public static boolean update(Teacher teacher) {
	Connection conn = DBConnect.getConnecttion();
	Statement statement = null;
	try {
		statement = conn.createStatement();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	System.out.println("teachername" + teacher.getName() + teacher.getUserId());
	String sql = "Update Teacher SET name = '" + teacher.getName() + "' where UserId = '" + teacher.getUserId() + "'"; 
	PreparedStatement ps;
	try {
//		ps = conn.prepareCall(sql);
		statement.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	return true;
}
}
