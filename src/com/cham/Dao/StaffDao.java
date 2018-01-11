package com.cham.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cham.DBConnect.DBConnect;
import com.cham.bean.Staff;

public class StaffDao {
	public static Staff getStaff(int userId) {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM Staff WHERE UserId = '"+userId+"'";
		PreparedStatement ps;
		Staff staff = null;
		//Staff staff = new Staff();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			staff = new Staff(rs.getInt("StaffId"),rs.getString("Name"), 
						rs.getInt("BirthYear"),rs.getString("Department"),rs.getInt("WorkDays"),
						rs.getFloat("CoefficientSalary"),rs.getString("Position"),rs.getString("Country"),
						rs.getInt("Allowance"),rs.getInt("Salary"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staff;
		
	}
	public ArrayList<Staff> getListStaffs() {
		Connection conn = DBConnect.getConnecttion();
		String sql ="SELECT * FROM Staff ";
		PreparedStatement ps;
		ArrayList<Staff> listStaff = new ArrayList<>();
		try {
			ps = conn.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Staff objStaff = new Staff(rs.getInt("StaffId"),rs.getString("Name"), 
						rs.getInt("BirthYear"),rs.getString("Department"),rs.getInt("WorkDays"),
						rs.getFloat("CoefficientSalary"),rs.getString("Position"),rs.getString("Country"),
						rs.getInt("Allowance"),rs.getInt("Salary"));
				listStaff.add(objStaff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStaff;
	}
}
