
package com.gms.dao;

import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

import com.gms.model.Complaint;
import com.gms.model.Users;

public class CitizenDaoImpl implements ICitizenDao {

	public int registerComplaint(Complaint complaint) throws Exception {
		System.out.println("into addhead");
		
		
		
		String sql = "insert into complaint (description,userremark,status,deptid,headremark,userId) values(?, ?, ?, ?,?,?)";
		System.out.println(sql);
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, complaint.getDescription());
		ps.setString(2, complaint.getUserRemark());
		ps.setString(3,complaint.getStatus());
		ps.setInt(4,complaint.getDeptId());
		ps.setString(5,complaint.getHeadRemark());
		ps.setInt(6,complaint.getUserId());
		
		return ps.executeUpdate();
	}
	  
	public  int getId(String username) throws Exception {
		String sql="select userid from users where username=?";
		System.out.println("username in dao"+username);
		System.out.println(sql);
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, username);
		ResultSet rs=ps.executeQuery();
		int id=0;
		while (rs.next()) {
			id=rs.getInt("userid");
			System.out.println("user id in dao"+id);
		}
		
		//System.out.println(rs.getInt("userid"));
		return id;
	}}
	


