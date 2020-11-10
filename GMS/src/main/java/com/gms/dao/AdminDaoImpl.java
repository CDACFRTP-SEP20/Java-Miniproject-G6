package com.gms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gms.model.Users;

public class AdminDaoImpl implements IAdminDao {

	public int addHead(Users head) throws Exception {

		System.out.println("into addhead");
		String sql = "insert into users (username,password,email,phoneno,address,role,deptid) values(?, ?, ?,?,?,?,?)";
		System.out.println(sql);
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);

		ps.setString(1, head.getUsername());
		ps.setString(2, head.getPassword());
		ps.setString(3, head.getEmail());
		ps.setString(4, head.getPhoneNo());
		ps.setString(5, head.getAddress());
		ps.setString(6, head.getRole());
		ps.setInt(7, head.getDeptId());

		return ps.executeUpdate();
	}

	public List<Users> getHeads() throws Exception {
		String sql = "select * from users";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Users> heads = new ArrayList<Users>();
		while (rs.next()) {
			if (rs.getString("role").equals("head")) {
				heads.add(new Users(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8)));
			}
		}
		return heads;

	}
	public int deleteHead(String username) throws Exception{
		String sql = "delete from users where username = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, username);			
		return ps.executeUpdate();
	}

	public Users getHead(String username) throws Exception {
		String sql = "select * from users where username = ?";
		Connection connection = DbUtil.getConnection();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		Users  user = null;
		if(rs.next()) {
			user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4),rs.getString(5),rs.getString(6),
					rs.getString(7),rs.getInt(8));
		}
		return user;
	}

	public int updateHead(Users user) throws Exception {
		String sql = "update users set password = ? , email=? , phoneno=? , address=? , role=? , deptid=? where username = ?";
		Connection connection = DbUtil.getConnection();
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		System.out.println(user.getPhoneNo());
		System.out.println(user.getAddress());
		System.out.println(user.getRole());
		System.out.println(user.getUsername());
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, user.getPassword());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPhoneNo());
		ps.setString(4, user.getAddress());
		ps.setString(5, user.getRole());
		ps.setInt(6, user.getDeptId());
		ps.setString(7, user.getUsername());
		
		return ps.executeUpdate();
	}
	
}
